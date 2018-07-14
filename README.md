20180714 星期六
--------------------------------
	1. 实现client登陆认证模式
	2. 悦听集成微信登陆
	3. 悦听集成手机号登陆

	
test
--------------------------------
	1. get code: localhost:10002/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://www.baidu.com
	2. get token: POST/GET http://client:secret@localhost:8080/oauth/token
	注意，URL中的client为上文中通过ClientDetailsServiceConfigurer类指定的clientId。由于authorization_code的授权方式不需要 client_secret, 因此secret可以填写任意值