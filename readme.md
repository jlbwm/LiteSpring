# Wheel Making 1 - Lite Spring

TDD: Think and write test case -> run, make sure run failure -> write just enough code, pass the test case -> refactoring code, keep the test case pase -> go to next loop 

## Version 1

Target：Implement the basic bean factory
Test case：Given a xml configuration file(include the bean defination), get the POJO from it.

commit 1: Implemented the basic BeanFactory class

 - Created the BeanFactory interface, implemented getBeanDefinition() and getBean()
 - Created the BeanDefinition interface, implemented getClassName()
 - Used dom4j implemented loadBeanDefinition(), traversed the entire bean XML, and stored in hash table
 
 commit 2: Improved the error handling
 
 - Created BeansException
 - Crateed BeansCreationException, BeansDefinitionStoreException extened from BeansException

## Version 2

Target：Implement Basic BeanFactory and encapsulate it as ApplicationContext

Issue 1：DefaultBeanFactory class has multiply responsibilities.
1. Read XML file and format as object of BeanFactory
2. Create Bean instance by reflect

method: Extract the XML parse part

Issue 2：BeanFactory and XMLBeanDefinitionReader should all located at the bottom layer, and not visible for higher layer

method: Use ApplicationContext to encapsulate them

Issue 3: Add the scope property in the Bean

method: See the below UML diagram

![image](/support/img/litespring.png)
