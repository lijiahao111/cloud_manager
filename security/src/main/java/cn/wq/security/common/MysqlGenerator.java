package cn.wq.security.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Scanner;

/**
 *@author chenchao
 *@Data 2023/3/27 16:51
 **/
public class MysqlGenerator {

    private static final String AUTHOR = "autoGen";
    private static final String ENTITY_IGNORE_PREFIX = "";

    /**
     * 父包名路径(文件输出路径,也是导包的路径)
     */
    private static String PROJECT_MODULE = "";

    private static String PARENT_PACKAGE_PATH = "cn.wq.security";
    // 各层包名
    private static String ENTITY_PATH = ".entity";
    private static String MAPPER_PATH = ".mapper";//
    private static String XML_PATH = "mapper";
    private static String SERVICE_PATH = ".service";//
    private static String SERVICE_IMPL_PATH = ".service.impl";//
    private static String CONTROLLER_PATH = ".controller";//

    // 数据库
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://localhost:3306/spring-cloud?serverTimezone=GMT%2B8&characterEncoding=UTF-8&allowMultiQueries=true";
    private static DbType DB_TYPE = DbType.MYSQL;
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 全局配置
     */
    private static GlobalConfig globalConfig() {

        return new GlobalConfig()
                // 打开文件
                .setOpen(false)
                // 文件覆盖
                .setFileOverride(true)
                // 开启activeRecord模式
                .setActiveRecord(true)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap: mapper.xml生成查询映射结果
                .setBaseResultMap(true)
                // XML ColumnList: mapper.xml生成查询结果列
                .setBaseColumnList(true)
                // swagger注解; 须添加swagger依赖
                //本项目没有该依赖
//                .setSwagger2(true)
                // 作者
                .setAuthor(AUTHOR)
                //输出路径
//                .setOutputDir(System.getProperty("user.dir")+"/"+PROJECT_MODULE+"/src/main/java");
                .setOutputDir("D:/project/cloud_manager/security/" + PROJECT_MODULE + "/src/main/java");
        // 设置实体类名称
        //.setEntityName("");
    }

    /**
     * 数据源配置
     */
    private static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DB_TYPE)
                // 连接驱动
                .setDriverName(driverClassName)
                // 地址
                .setUrl(url)
                // 用户名
                .setUsername(username)
                // 密码
                .setPassword(password)
                .setTypeConvert(new MySqlTypeConvertCustom());
    }

    /**
     * 策略配置
     */
    private static StrategyConfig strategyConfig() {

        return new StrategyConfig()
                // 表名生成策略：下划线连转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 表字段生成策略：下划线连转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的表
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                // 生成controller
                .setRestControllerStyle(true)
                // 公共父类
                .setSuperControllerClass("cn.wq.security.common.base.PlatformBaseController")
                .setSuperMapperClass("cn.wq.security.common.base.PlatformBaseMapper")
                // 去除表前缀
                .setTablePrefix(ENTITY_IGNORE_PREFIX)//"t_"
                // controller映射地址：驼峰转连字符
                .setControllerMappingHyphenStyle(true)
                // 是否启用builder 模式
//                .setEntityBuilderModel(true)
                // 是否为lombok模型; 需要lombok依赖
                .setEntityLombokModel(true)
                //驼峰的控制。这里设置为原样输出。默认下划线转驼峰
//                .setColumnNaming(NamingStrategy.no_change)
                // 生成实体类字段注解
                .setEntityTableFieldAnnotationEnable(true);
    }

    /**
     * 包配置
     * 设置包路径用于导包时使用，路径示例：com.path
     */
    private static PackageConfig packageConfig() {

        String codePackage = PARENT_PACKAGE_PATH;
        String configPackage = "";

        String module = scanner("模块名[可输入:,enterprise,project,user]");
        if (!StringUtils.isBlank(module)) {
            codePackage += "." + module;
        }

        String entity = codePackage + ENTITY_PATH;
        String mapper = codePackage + MAPPER_PATH;
        String service = codePackage + SERVICE_PATH;
        String serviceImpl = codePackage + SERVICE_IMPL_PATH;
        String controller = codePackage + CONTROLLER_PATH;

        String xml = XML_PATH + "/" + module;

        PackageConfig pc = new PackageConfig()
                // 父包名
                .setParent("")
//                .setModuleName(scanner("模块名"))
                .setEntity(entity)
                .setMapper(mapper)
//                .setXml(xml)
                .setService(service)
                .setServiceImpl(serviceImpl)
                .setController(controller);

        return pc;
    }

    public static void main(String[] args) {


        // 全局配置
        GlobalConfig globalConfig = globalConfig();
        // 数据源配置
        DataSourceConfig dataSourceConfig = dataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = strategyConfig();
        // 包配置
        PackageConfig packageConfig = packageConfig();

        // 执行
        AutoGenerator autoGen = new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        // 因为使用了自定义模板,所以需要把各项置空否则会多生成一次
//                .setTemplate(templateConfig)
        // 使用的模板引擎，如果不是默认模板引擎则需要添加模板依赖到pom
//                .setTemplateEngine(new FreemarkerTemplateEngine())
//                .setCfg(injectionConfig)

        autoGen.execute();

//        genXml(autoGen);
//        genController(mpg);

    }

    private static void genXml(AutoGenerator autoGen) {
        autoGen.getGlobalConfig().setOutputDir(System.getProperty("user.dir") + "/" + PROJECT_MODULE + "/src/main/resources");
//        autoGen.getPackageInfo().setXml("/"+XML_PATH);
        autoGen.execute();
    }

    private static void genController(AutoGenerator mpg) {

        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);
        tc.setEntity(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setMapper(null);
        tc.setXml(null);
        mpg.setTemplate(tc);

/*

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", "test");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 controller 生成目录演示
        String projectPath = mpg.getGlobalConfig().getOutputDir();
        String packagePath = projectPath + "/" + mpg.getPackageInfo().getParent().replace(".","/") + "/" + mpg.getPackageInfo().getController()+"/";

        focList.add(new FileOutConfig("/controller.java.vm") {//templates/
            @Override
            public String outputFile(TableInfo tableInfo) {
                //输出的位置
                String output = packagePath + tableInfo.getEntityName() + "Controller.java";
                System.out.println("---"+output);
                return output;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
*/

        mpg.execute();
    }

    /**
     * 自定义类型转换
     */
    static class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {
        @Override
        public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
            String t = fieldType.toLowerCase();
            if (t.contains("tinyint(1)")) {
                return DbColumnType.INTEGER;
            }
            return super.processTypeConvert(globalConfig, fieldType);
        }
    }
}
