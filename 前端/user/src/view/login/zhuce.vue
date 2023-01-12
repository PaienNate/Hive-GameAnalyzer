<template>
	<div id="bg">
	<div id="container-register">
		<div id="title">
			<i class="material-icons lock">lock</i> 注册页面
		</div>

		<form ref="registerForm">
			<div class="input">
				<div class="input-addon">
					<i class="material-icons">email</i>
				</div>
				<input id="email" v-model="registerForm.email" placeholder="邮箱" type="email" required class="validate"
					autocomplete="off">
			</div>

			<div class="clearfix"></div>

			<div class="input">
				<div class="input-addon">
					<i class="material-icons">face</i>
				</div>
				<input id="username" v-model="registerForm.name" placeholder="用户名(昵称)" type="text" required
					class="validate" autocomplete="off">
			</div>

			<div class="clearfix"></div>

			<div class="input">
				<div class="input-addon">
					<i class="material-icons">vpn_key</i>
				</div>
				<input id="password" v-model="registerForm.password" placeholder="密码" type="password" required
					class="validate" autocomplete="off">
			</div>

			<div class="remember-me">
				<input @click="register()" type="submit" value="单击注册" />
			</div>
		</form>


		<div class="register">
			<span style="color: #657575">已经有了账号？</span><br>
			<a @click="gologin()"><button id="register-link">点击这里去登录页面！</button></a>
		</div>
	</div>
	</div>
</template>

<script>
import home from '../../store/home'
import {userreg} from '../../http/login/login'
export default {
	name: 'Register',
	data() {
		return {
			registerForm: {
				email: "email",
				name: "name",
				password: "password"
			}
		}
	},
	methods: {
		register() {
			userreg(this.registerForm).then(res => {
				if (res.code != 200) {
					//使用弹窗提示错误信息
					this.$message({
						message: res.msg,
						type: 'error'
					})
				}
				else {
					//做跳转到登录界面
					home().menuRouteLoaded(false)    // 要求重新加载导航菜单
					this.$router.push('/login')  // 登录成功，跳转到主页
				}
				console.log(res)
			})
		},
		gologin()
		{
			home().menuRouteLoaded(false)    // 要求重新加载导航菜单
			this.$router.push('/login')  //  要求登录
		 
		}


	}
}







</script>

<style scoped>



/* main.css import for google*/
/* cyrillic-ext */
@font-face {
	font-family: 'Raleway';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/raleway/v28/1Ptxg8zYS_SKggPN4iEgvnHyvveLxVvaorCFPrEHJA.woff2) format('woff2');
	unicode-range: U+0460-052F, U+1C80-1C88, U+20B4, U+2DE0-2DFF, U+A640-A69F, U+FE2E-FE2F;
}

/* cyrillic */
@font-face {
	font-family: 'Raleway';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/raleway/v28/1Ptxg8zYS_SKggPN4iEgvnHyvveLxVvaorCMPrEHJA.woff2) format('woff2');
	unicode-range: U+0301, U+0400-045F, U+0490-0491, U+04B0-04B1, U+2116;
}

/* vietnamese */
@font-face {
	font-family: 'Raleway';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/raleway/v28/1Ptxg8zYS_SKggPN4iEgvnHyvveLxVvaorCHPrEHJA.woff2) format('woff2');
	unicode-range: U+0102-0103, U+0110-0111, U+0128-0129, U+0168-0169, U+01A0-01A1, U+01AF-01B0, U+1EA0-1EF9, U+20AB;
}

/* latin-ext */
@font-face {
	font-family: 'Raleway';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/raleway/v28/1Ptxg8zYS_SKggPN4iEgvnHyvveLxVvaorCGPrEHJA.woff2) format('woff2');
	unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
}

/* latin */
@font-face {
	font-family: 'Raleway';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/raleway/v28/1Ptxg8zYS_SKggPN4iEgvnHyvveLxVvaorCIPrE.woff2) format('woff2');
	unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
}

body {
	margin: 0;
	padding: 0;
	font-family: 'Raleway', sans-serif;
	color: #F2F2F2;
	background-image: url("/img/back1.jpg");
}

#bg {
	width: 100%;
	height: 100%;
	background-image: url("/img/back1.jpg");
}
#container-login {
	background-color: #FCFCFC;
	position: relative;
	top: 20%;
	margin: auto;
	width: 340px;
	height: 445px;
	border-radius: 0.35em;
	box-shadow: 0 3px 10px 0 rgba(0, 0, 0, 0.25);
	text-align: center;
	
}

#container-register {
	background-color: #FCFCFC;
	position: relative;
	top: 20%;
	margin: auto;
	width: 400px;
	height: 400px;
	border-radius: 0.35em;
	box-shadow: 0 3px 10px 0 rgba(0, 0, 0, 0.25);
	text-align: center;
	
}

#title {
	position: relative;
	background-color: #30424c;
	width: 100%;
	padding: 20px 0px;
	border-top-left-radius: 0.22em;
	border-top-right-radius: 0.22em;
	font-size: 22px;
	color: #fff;
	border-bottom: 1px solid rgba(255, 255, 255, 0.05);
}

.lock {
	position: relative;
	top: 2px;
}

.input {
	margin: auto;
	width: 240px;
	border-radius: 4px;
	background-color: #ededed;
	padding: 8px 0px;
	margin-top: 15px;
}

.input-addon {
	position: relative;
	top: -2px;
	float: left;
	background-color: #ededed;
	border: 1px solid #ededed;
	padding: 4px 8px;
	color: #757575;
	border-right: 1px solid #757575;
}

input[type=checkbox] {
	cursor: pointer;
}

input[type=text] {
	color: #949494;
	margin: 0;
	background-color: #ededed;
	border: 1px solid #ededed;
	padding: 6px 0px;
	border-radius: 3px;
}

input[type=text]:focus {
	border: 1px solid #ededed;
}

input[type=password] {
	color: #949494;
	margin: 0;
	background-color: #ededed;
	border: 1px solid #ededed;
	padding: 6px 0px;
	border-radius: 3px;
}

input[type=password]:focus {
	border: 1px solid #ededed;
}

input[type=email] {
	color: #949494;
	margin: 0;
	background-color: #ededed;
	border: 1px solid #ededed;
	padding: 6px 0px;
	border-radius: 3px;
}

input[type=email]:focus {
	border: 1px solid #ededed;
}

.forgot-password {
	position: relative;
	bottom: 0%;
}

.forgot-password a:link {
	color: #30424c;
	text-decoration: none;
}

.forgot-password a:visited {
	color: #30424c;
	text-decoration: none;
}

.forgot-password a:hover {
	color: #449494;
	transition: color 1s;
}

.privacy {
	margin-top: 5px;
	position: relative;
	font-size: 12px;
	bottom: 0%;
}

.privacy a:link {
	color:#30424c;
	text-decoration: none;
}

.privacy a:visited {
	color: #30424c;
	text-decoration: none;
}

.privacy a:hover {
	color: #549494;
	transition: color 1s;
}

*:focus {
	outline: none;
}

.remember-me {
	margin: 10px 0;
}

input[type=submit] {
	padding: 6px 25px;
	background: #30424c;
	color: #fff;
	font-weight: bold;
	border: 0 none;
	cursor: pointer;
	border-radius: 30px;
}

.register {
	margin: auto;
	padding: 10px 0;
	text-align: center;
	margin-top: 20px;
	width: 85%;
	border-top: 1px solid #C1C3C6;
}

.clearfix {
	clear: both;
}

#register-link {
	margin-top: 10px;
	padding: 5px 20px;
	background: #30424c;
	color: #fff;
	font-weight: bold;
	border: 0 none;
	cursor: pointer;
	border-radius: 20px;
}

/* fallback */
@font-face {
	font-family: 'Material Icons';
	font-style: normal;
	font-weight: 400;
	src: url(https://fonts.gstatic.com/s/materialicons/v139/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2) format('woff2');
}

.material-icons {
	font-family: 'Material Icons';
	font-weight: normal;
	font-style: normal;
	font-size: 24px;
	line-height: 1;
	letter-spacing: normal;
	text-transform: none;
	display: inline-block;
	white-space: nowrap;
	word-wrap: normal;
	direction: ltr;
	-webkit-font-feature-settings: 'liga';
	-webkit-font-smoothing: antialiased;
}
</style>
