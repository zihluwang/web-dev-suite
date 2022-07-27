## Web Dev Suite

本项目由 **JetBrains** 赞助

[![JetBrains Logo (Main) logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png)](https://www.jetbrains.com/community/opensource/?utm_campaign=opensource&utm_content=approved&utm_medium=email&utm_source=newsletter&utm_term=jblogo#support)

这是一个以 `RESTful` 接口为概念而创建的类库。该类库中的 `ResponseResult<T>` 可以规范您的 `JSON` 响应内容。其次，该类库还封装了常用的 
Web 响应代码，例如表示成功的 200 (OK)等。

在此次更新中，我们也添加了对业务进行断言的 `BizAssert` 工具类，通过这个断言工具，就可以轻松抛出可以转换成 `ResponseResult` 的 
`BizException`。此次更新还添加了可以轻松配置的 `CorsFilter` 。在开发过程中，我们经常可以遇到浏览器的跨域请求问题，因此，通过这个过滤器为
响应数据添加一些能让浏览器通过跨域请求检查的响应头。