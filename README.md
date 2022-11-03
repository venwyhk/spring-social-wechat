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

<table>
    <tr>
        <th>Provider Name</th>
        <th>Provider Id</th>
        <th>Authorization Type</th>
        <th>Parameters</th>
        <th>Required</th>
        <th>Default</th>
    </tr>
    <tr>
        <td rowspan="3"><a href="https://open.weixin.qq.com/">WeChat Open Platform</a></td>
        <td rowspan="3">wechat</td>
        <td rowspan="3">QR Code</td>
        <td>spring.social.wechat.app-id</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wechat.app-secret</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wechat.check-state</td>
        <td>no</td>
        <td>true</td>
    </tr>
    <tr>
        <td rowspan="3"><a href="https://mp.weixin.qq.com/">WeChat Official Accounts Platform</a></td>
        <td rowspan="3">wechatmp</td>
        <td rowspan="3">Webpage</td>
        <td>spring.social.wechatmp.app-id</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wechatmp.app-secret</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wechatmp.check-state</td>
        <td>no</td>
        <td>true</td>
    </tr>
    <tr>
        <td rowspan="4" ><a href="https://work.weixin.qq.com">WeChat Work</a></td>
        <td rowspan="4">wecom</td>
        <td rowspan="4">QR Code</td>
        <td>spring.social.wecom.crop-id</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wecom.agent-id</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wecom.secret</td>
        <td>yes</td>
        <td></td>
    </tr>
    <tr>
        <td>spring.social.wechat.check-state</td>
        <td>no</td>
        <td>true</td>
    </tr>
</table>


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
