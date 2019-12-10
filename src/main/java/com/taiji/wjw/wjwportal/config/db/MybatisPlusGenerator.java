/*
 * Copyright (C) 2019  FunGuide, Inc. All Rights Reserved.
 */


package com.taiji.wjw.wjwportal.config.db;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * Simple to Introduction
 * className: MybatisPlusConfig
 *
 * @author yanxw
 * @version 2019/4/15 13:56
 */


public class MybatisPlusGenerator {
    public static void main(String[] args) {
            //用来获取mybatis-plus.properties文件的配置信息
            final ResourceBundle rb = ResourceBundle.getBundle("generator");
            AutoGenerator mpg = new AutoGenerator();
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir(rb.getString("OutputDir"))
                    .setFileOverride(false)// 是否覆盖文件
                    .setActiveRecord(false)// 开启 activeRecord 模式
                    .setEnableCache(false)// XML 二级缓存
                    .setBaseResultMap(true)// XML ResultMap
                    .setBaseColumnList(true)// XML columList
                    .setAuthor(rb.getString("author"))
                    // 自定义文件命名，注意 %s 会自动填充表实体属性！
                    .setXmlName("%sMapper").setMapperName("%sMapper");
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL)
                    .setDriverName(rb.getString("DRIVER"))
                    .setUrl(rb.getString("URL"))
                    .setUsername(rb.getString("USER_NAME"))
                    .setPassword(rb.getString("PASSWORD"));

        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/
            mpg.setDataSource(dsc);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
            //strategy.setTablePrefix(new String[] { "SYS_" });// 此处可以修改为您的表前缀
            strategy.setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                 .setInclude(new String[] {"user","department"}) // 需要生成的表
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true);
            //strategy.setExclude(new String[]{"test"}); // 排除生成的表
            mpg.setStrategy(strategy);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent(rb.getString("parent"))
            // pc.setModuleName("tbldept");//模块名称，单独生成模块时使用！！！！！！！！！！！
                .setController("controller")
//                .setService("service")
                .setServiceImpl("service.impl")
                .setEntity("entity")
                .setMapper("mapper");
            mpg.setPackageInfo(pc);

            // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                    this.setMap(map);
                }
            };

            // 调整 xml 生成目录演示
            List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
            focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return rb.getString("OutputDirXml")+ "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            // 关闭默认 xml 生成，调整生成 至 根目录
            TemplateConfig tc = new TemplateConfig();
            tc.setXml(null);
//            tc.setController(null); 取消生成Controller
            mpg.setTemplate(tc);

            // 执行生成
            mpg.execute();
    }
}

