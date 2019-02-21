package com.spring.jpa.springjpa.service;

import com.spring.jpa.springjpa.utilTools.Criterion;
import com.spring.jpa.springjpa.utilTools.FieldMapUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseService<T> {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 获取查询翻页条件
     * @param t  实体类对象
     * @param isFlag 是否封装isFlag有效标识字段
     * @param isFlagValue 有效标识字段值
     * @param map 查询字段查询方式map
     * @return
     */
    public Specification<T> findPageList(final T t, boolean isFlag, String isFlagValue, HashMap<String, String> map) {
        Field[] fields = FieldMapUtil.getFields(t);
        Criterion<T> criterion = new Criterion<T>();
        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                for(Field field : fields) {
                    String name = FieldMapUtil.getFieldName(field);
                    String value = FieldMapUtil.getFieldValue(name,t);
                    if (!StringUtils.isEmpty(value)) {
                        String queryOperator = map.get(name);
                        list.add(criterion.getQuerCriterion(root, queryOperator, name, value, criteriaBuilder));
                        //list.add(criteriaBuilder.like(root.get(name).as(String.class), "%" + value + "%"));
                    }
                }
                if(isFlag){
                    list.add(criteriaBuilder.equal(root.get("isFlag").as(String.class), isFlagValue));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        return specification;
    }

    /**
     * 查询返回返回结果对象
     * @param sql  sql语句
     * @param params 填充问号占位符数
     * @return
     */
    public <T> T queryOne(String sql,Object[] params,Class<T> cla){
        T result=null;
        try{
            if(params==null||params.length>0){
                result=jdbcTemplate.queryForObject(sql,params,cla);
            }else{
                result=jdbcTemplate.queryForObject(sql,cla);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 查询返回实体对象集合
     * @param sql    sql语句
     * @param params 填充sql问号占位符数
     * @param cla    实体对象类型
     * @return
     */
    public List queryForObjectList(String sql,Object[] params,final Class cla){
        final List list=new ArrayList();
        try{
            jdbcTemplate.query(sql, params, new RowCallbackHandler(){
                public void processRow(ResultSet rs) {
                    try{
                        List<String> columnNames=new ArrayList<String>();
                        ResultSetMetaData meta=rs.getMetaData();
                        int num=meta.getColumnCount();
                        for(int i=0;i<num;i++){
                            columnNames.add(meta.getColumnLabel(i+1).toLowerCase().trim());
                        }
                        Method[] methods=cla.getMethods();
                        List<String> fields=new ArrayList<String>();
                        for(int i=0;i<methods.length;i++){
                            if(methods[i].getName().trim().startsWith("set")){
                                String f=methods[i].getName().trim().substring(3);
                                f=(f.charAt(0)+"").toLowerCase().trim()+f.substring(1);
                                fields.add(f);
                            }
                        }
                        do{
                            Object obj=null;
                            try{
                                obj=cla.getConstructor().newInstance();
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                            for(int i=0;i<num;i++){
                                Object objval=rs.getObject(i+1);
                                for(int n=0;n<fields.size();n++){
                                    String fieldName=fields.get(n).trim();
                                    if(columnNames.get(i).equals(fieldName.toLowerCase().trim())){
                                        BeanUtils.copyProperty(obj, fieldName, objval);
                                        break;
                                    }
                                }
                            }
                            list.add(obj);
                        }while(rs.next());
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
        }catch(Exception ex){ex.printStackTrace();}
        if(list.size()<=0){
            return null;
        }
        return list;
    }

    /**
     * 查询返回List<Map<String,Object>>格式数据,每一个Map代表一行数据，列名为key
     * @param sql  sql语句
     * @param params 填充问号占位符数
     * @return
     */
    public List<Map<String,Object>> queryForMaps(String sql, Object[] params){
        try{
            if(params!=null&&params.length>0){
                return jdbcTemplate.queryForList(sql, params);
            }
            return jdbcTemplate.queryForList(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
