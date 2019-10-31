## Nginx 开发资料
* [Nginx 官方文档](http://nginx.org/en/docs/)
* [章亦春的Nginx教程](http://openresty.org/download/agentzh-nginx-tutorials-zhcn.html)



# openresty-primer


## Openresty工作原理

ngx_lua模块的原理：
1. 每个worker（工作进程）创建一个Lua VM，worker内所有协程共享VM；
2. 将Nginx I/O原语封装后注入 Lua VM，允许Lua代码直接访问；
3. 每个外部请求都由一个Lua协程处理，协程之间数据隔离；
4. Lua代码调用I/O操作等异步接口时，会挂起当前协程（并保护上下文数据），而不阻塞worker；
5. I/O等异步操作完成时还原相关协程上下文数据，并继续运行；


ngx_lua将Lua嵌入Nginx，可以让Nginx执行Lua脚本，并且高并发、非阻塞的处理各种请求。
Lua内建协程，这样就可以很好的将异步回调转换成顺序调用的形式。
ngx_lua在Lua中进行的IO操作都会委托给Nginx的事件模型，从而实现非阻塞调用。
开发者可以采用串行的方式编写程序，ngx_lua会自动的在进行阻塞的IO操作时中断，保存上下文；然后将IO操作委托给Nginx事件处理机制，在IO操作完成后，ngx_lua会恢复上下文，程序继续执行，这些操作都是对用户程序透明的。
每个NginxWorker进程持有一个Lua解释器或者LuaJIT实例，被这个Worker处理的所有请求共享这个实例。
每个请求的Context会被Lua轻量级的协程分割，从而保证各个请求是独立的。 
ngx_lua采用“one-coroutine-per-request”的处理模型，对于每个用户请求，ngx_lua会唤醒一个协程用于执行用户代码处理请求，当请求处理完成这个协程会被销毁。每个协程都有一个独立的全局环境（变量空间），继承于全局共享的、只读的“comman data”。
所以，被用户代码注入全局空间的任何变量都不会影响其他请求的处理，并且这些变量在请求处理完成后会被释放，这样就保证所有的用户代码都运行在一个“sandbox”（沙箱），这个沙箱与请求具有相同的生命周期。 
得益于Lua协程的支持，ngx_lua在处理10000个并发请求时只需要很少的内存。根据测试，ngx_lua处理每个请求只需要2KB的内存，如果使用LuaJIT则会更少。所以ngx_lua非常适合用于实现可扩展的、高并发的服务。


----


## 通过请求参数限流


---


## openresty 开发资料
* [openresty官方文档-EN](https://github.com/openresty/lua-nginx-module/blob/master/README.markdown)
* [openresty官方文档-ZH](https://github.com/iresty/nginx-lua-module-zh-wiki)
* [openresty最佳实践](https://moonbingbing.gitbooks.io/openresty-best-practices/content/)
* [openresty最佳实践-看云](https://www.kancloud.cn/allanyu/openresty-best-practices/82569)
* [openresty网上论坛](https://groups.google.com/forum/#!forum/openresty)