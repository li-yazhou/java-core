# spring-annotations

## 常用注解

| 注解 | 描述 |
|---|---|
| @Component |泛指组件，当组件不好归类时，可以使用这个注解进行标注 |
| @Controller | 用于标注控制层组件，其标记在一个类上，使用它标记的类就是一个SpringMVC Controller对象，分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了@RequestMapping注解，可以把Request请求header部分的值绑定到方法的参数上 |
| @Service | 用于注解业务层组件，在Service的实现类上注解 |
| @Repository | 用于注解DAO层组件，在Dao的实现类上注解 |
|||
| @RestController | 相当于@Contoller和@ResponseBody的组合 |
| @ResponseBody | 异步请求，该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。返回的数据不是html页面，而是其他的某种格式的数据时使用，如json、xml等 |
| @RequestMapping | 一个用于处理请求地址映射的注解，可用于类或非法上，用于类上表示类中的所有响应请求的方法都是以该地址作为父路径 |
| @Autowired | 可以标注类的成员变量、方法及构造方法，完成自动装配的工作，通过@Autowired的使用来消除set、get方法 |
| @PathVariable | 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出URL模板中的变量作为参数 |
| @RequestParam | 主要用于在SpringMVC后台控制层获取参数，类似是 request.getParameter("name") |
| @RequestHandler | 可以把Request请求header部分的值绑定到方法的参数上 | 
|||
| @ModelAttribute | 该Controller的所有方法在调用前，先执行才@ModelAttribute方法，可用于注解方法参数中，可以把这个@ModelAttribute特性应用在BaseController当中，所偶的Controller继承BaseController，即可以实现调用Controller时，先执行@ModelAttribute方法 |
| @SessionAttributes | 即将值放到session作用域中，写在类上面 | 
| @Valid | 实体数据校验，可以结合hibernate validator一起使用 |
| @CookieValue | 用来获取Cookie中的值 |







































