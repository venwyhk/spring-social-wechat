[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ikasoa/spring-social-wechat/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ikasoa/spring-social-wechat)

# spring-social-wechat #

## Installing ##

Production releases are available on *Maven Central*.

In Gradle:

```groovy
implementation 'com.ikasoa:spring-social-wechat:${version}'
```

Or in Maven:

```xml
<dependency>
    <groupId>com.ikasoa</groupId>
    <artifactId>spring-social-wechat</artifactId>
    <version>${version}</version>
</dependency>
```

## Description ##

|  Provider Name   | Provider Id  | Parameters | Authorization Type |
|  ----  | ---- | ---- | ---- |
| [WeChat Open Platform](https://open.weixin.qq.com/)  | wechat | spring.social.wechat.app-id<br/>spring.social.wechat.app-secret<br/>spring.social.wechat.check-state | QR Code |
| [WeChat Official Accounts Platform](https://mp.weixin.qq.com/)  | wechatmp | spring.social.wechatmp.app-id<br/>spring.social.wechatmp.app-secret<br/>spring.social.wechat.check-state | Webpage |
| [WeChat Work](https://work.weixin.qq.com/)  | wecom | spring.social.wecom.app-id<br/>spring.social.wecom.agent-id<br/>spring.social.wecom.app-secret<br/>spring.social.wechat.check-state | QR Code |


## HTML Example ##

```html
<form action="/signin/[ProviderId]" method="POST">
    <button type="submit">Log in</button>
</form>
```

## Sample ##

[spring-social-wechat-sample](https://github.com/venwyhk/spring-social-wechat-sample)

***

[![](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png)](https://creativecommons.org/licenses/by-nc-sa/4.0/)&nbsp;&nbsp;
