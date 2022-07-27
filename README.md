## Web Dev Suite

Sponsored by **JetBrains**

[![JetBrains Logo (Main) logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.png)](https://www.jetbrains.com/community/opensource/?utm_campaign=opensource&utm_content=approved&utm_medium=email&utm_source=newsletter&utm_term=jblogo#support)

> You could also read the **CHINESE** version of [README](README_zh-CN.md)

This is a class library created with the concept of `RESTful` interface. The `ResponseResult<T>` in this library can 
standardize the content of your `JSON` response. Secondly, the library also encapsulates commonly used Web response 
codes, such as 200 (OK) for success, etc.

In this update, we have also added the `BizAssert` tool class that asserts the business. With this assertion tool, you 
can easily throw the `BizException` that can be converted into `ResponseResult`. This update also adds a `CorsFilter` 
which can be easily configured. During the development process, we can often encounter the problem of cross-domain 
request of the browser. Therefore, through this filter, response data will be added some response headers that allow 
browsers to pass cross-origin request checks.
