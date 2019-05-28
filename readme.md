#Wheel Making 1 - Lite Spring

TDD：思考-写测试用例 -> 运行，保证失败 -> 写just enough 的代码，让测试通过 -> 重构代码， 保持测试通过 -> 进入下一轮

##Version 1

目标：实现基本的Bean Factory
测试：给定一个xml配置文件（内含bean的定义），能够从中获取 POJO

commit 1: 实现了基本的BeanFactory Class

 - 创建BeanFactory接口，实现 getBeanDefinition， getBean方法
 - 创建BeanDefinition接口，实现 getClassName功能
 - 使用dom4j 实现loadBeanDefinition method, 遍历整个bean xml, 存入hash表中
 
 commit 2: 优化异常处理
 
 - 创建BeansException
 - 创建继承BeansException的BeansCreationException, BeansDefinitionStoreException

