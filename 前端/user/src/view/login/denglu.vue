<template>

	<div class="content login-bg" >
		<div class="form sign-in">
			<h2>欢迎回来</h2>
			<el-form :model="loginForm" @keyup.enter="login" status-icon :rules="rules" ref="loginForm" class="demo-loginForm">
				<label>
					<el-form-item label="" prop="pass">
						<span>用户名</span>
						<input v-model="loginForm.account" autocomplete="off" placeholder='' />
					</el-form-item>
				</label>
				<label>
					<el-form-item label="" prop="checkPass">
						<span>密码</span>
						<input type="password" v-model="loginForm.password" autocomplete="off" placeholder=' '
							show-password />
					</el-form-item>
				</label>
				<label>
				<el-form-item >
				  <el-col :span="12">
				    <el-form-item prop="captcha">
				      <el-input type="test" v-model="loginForm.captcha" auto-complete="off" placeholder="验证码, 单击图片刷新"
				        style="width: 100%;">
				      </el-input>
				    </el-form-item>
				  </el-col>
				  <el-col class="line" :span="1">&nbsp;</el-col>
				  <el-col :span="11">
				    <el-form-item>
				        <img style="width: 100%;" class="pointer" :src="loginForm.src" @click="refreshCaptcha">
				    </el-form-item>
				  </el-col>
				</el-form-item>
				</label>
				<el-form-item>
					<el-button class='btn submit' @click.native.prevent="login">提交</el-button>
				</el-form-item>
				<el-button class='btn submit' @click.native.prevent="goregister">注册账号</el-button>
			</el-form>
		</div>
		<div class="sub-cont">
			<div class="img">
				<div class="img__text m--up">
					<h2>忘记密码？</h2>
					<p>点击右侧按钮恢复密码！</p>
				</div>
				<div class="img__text m--in">
					<h2>想起了密码？</h2>
					<p>想起了密码就去登录吧</p>
				</div>
				<div class="img__btn">
					<span class="m--up">忘记密码</span>
					<span class="m--in">登 录</span>
				</div>
			</div>
			<div class="form sign-up">
				<h2>忘记密码</h2>
				<el-form :model="ruleFormRepass" status-icon :rules="myrules" ref="ruleFormRepass" class="demo-ruleForm">
					<!-- 修改这个按钮 -->
					<p>请先获取验证码并填入验证码</p>
					<label>
						<span>输入邮箱</span>
						<el-form-item label="" prop="check">
							<input v-model="ruleFormRepass.email"/>
						</el-form-item>
					</label>
					<!-- 改成一个按钮点击 -->
					<label v-show="ruleFormRepass.havesend">
						<span>输入验证码</span>
						<el-form-item label="" prop="check">
							<input v-model="ruleFormRepass.check"/>
						</el-form-item>
					</label>
					<label>
						<span>输入新密码</span>
						<el-form-item label="" prop="newpass">
							<input v-model="ruleFormRepass.newpass" type="password" />
						</el-form-item>
					</label>
					<button type="button" class="fb-btn" @click="sendMail()">获取 <span>验证码</span> </button>
					<el-button type="button" class="submit" @click="repasswd()" v-show="ruleFormRepass.havesend">重 置 密 码</el-button>
				</el-form>
			</div>
		</div>
</div>
</template>
<script>
import {userlogin,useremail,userchangepass} from '../../http/login/login'
import home from '@/store/home';
	export default {
		data() {

			let name = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请输入用户名'));
				} else {
					if (this.ruleForm.checkPass !== '') {
						this.$refs.ruleForm.validateField('checkPass');
					}
					callback();
				}
			};
			let validatePass = (rule, value, callback) => {
				if (value === '') {
					callback(new Error('请输入密码'));
				} else {
					callback();
				}
			};
			return {

				loginForm: {
				  account: 'admin',
				  password: '123456',
				  captcha:'',
				  src: ''
				},
				ruleForm: {
					pass: '',
					checkPass: ''
				},
				ruleFormRepass: {
					email:'',
					name: '',
					check: '',
					newpass: '',
					havesend: false,
				},
				rules: {
					pass: [{
						validator: name,
						trigger: 'blur'
					}],
					checkPass: [{
						validator: validatePass,
						trigger: 'blur'
					}]
				},
				myrules: {
					check: [{
						required: true,
						message: '请输入验证码',
						trigger: 'blur'
					}],
					newpass: [{
						required: true,
						message: '请输入新密码',
						trigger: 'blur'
					}]
				}
			};
		},
		methods: {
			// submitForm(formName) {
			// 	this.$refs[formName].validate((valid) => {
					
			// 		if (valid) {
			// 			this.login();
			// 		} else {
			// 			console.log('error submit!!');
			// 			return false;
			// 		}
			// 	});
			// },
			goregister()
			{
				home().menuRouteLoaded(false)    // 要求重新加载导航菜单
			    this.$router.push('/register') 
			},

			login() {
			  let userInfo = {name:this.loginForm.account, password:this.loginForm.password, captcha:this.loginForm.captcha}
			  userlogin(userInfo).then((res) => {
			    //   if(res.code != 200) {
			    //     Elmessage({
			    //       message: res.msg,
			    //       type: 'error'
			    //     })
			    //   } else {
			        sessionStorage.setItem('token', res.token) // 放置token到Cookie
			        sessionStorage.setItem('user', userInfo.name) // 保存用户到本地会话
			        let userName = sessionStorage.getItem('user')
					home().menuRouteLoaded(false)    // 要求重新加载导航菜单
			        this.$router.push('/')  // 登录成功，跳转到主页
			    //   }
			    })
				// .catch((res) => {
			    //   Elmessage({
			    //   message: res.message,
			    //   type: 'error'
			    //   })
			    // });
			},
			refreshCaptcha: function(){
			  this.loginForm.src = "/api" + "/captcha.jpg?t=" + new Date().getTime();
			},
			sendMail() {
				let useemail = {email:this.ruleFormRepass.email};

				//发送重置密码请求，得到邮箱验证码
				useremail(useemail).then(res=>{
					//检测不是200时，报错提示
					// if(res.code!=200)
					// {
					// 	Elmessage({
              		// 	message: res.msg,
              		// 	type: 'error'
            		// 	})
					// }
					// else{
						//显示输入验证码的框
						this.ruleFormRepass.havesend = true;
					// }
				}
				)
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},
			//使用验证码和新密码修改密码（找回）
			repasswd() {
				let verifyinfo = {verify:this.ruleFormRepass.check,newpass:this.ruleFormRepass.newpass}
				userchangepass(verifyinfo).then(res => {
				// if (res.code != 200) {
				// 	//使用弹窗提示错误信息
				// 	Elmessage({
				// 		message: res.msg,
				// 		type: 'error'
				// 	})
				// }
				// else {
					//做跳转到登录界面
					home().menuRouteLoaded(false)    // 要求重新加载导航菜单
					this.$router.push('/login')
				// }
				// console.log(res)
			})
			}
		},
		// 先把组件创建出来后，再template挂载DOM上后
		mounted()
		{
			this.refreshCaptcha()
			document.querySelector('.img__btn').addEventListener('click', function() {
			    document.querySelector('.content').classList.toggle('s--signup')
			})
		}
	}
</script>
<style scoped>
	/* 添加模板CSS */
	*,
	*:before,
	*:after {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}


	.el-input.el-input__inner {
		border: none;
		outline: none;
		background: none;
		font-family: 'Open Sans', Helvetica, Arial, sans-serif;

	}
	body {
    font-family: 'Open Sans', Helvetica, Arial, sans-serif;
    background-color: #ededed;
	}

	input,button {
		border: none;
		outline: none;
		background: none;
		font-family: 'Open Sans', Helvetica, Arial, sans-serif;
	}
	button {
		display: block;
		margin: 0 auto;
		width: 260px;
		height: 36px;
		border-radius: 30px;
		color: #fff;
		font-size: 15px;
		cursor: pointer;
	}

	h2 {
		width: 100%;
		font-size: 26px;
		text-align: center;
	}
	
	label {
		display: block;
		width: 260px;
		margin: 25px auto 0;
		text-align: center;
	}
	
	label span {
		font-size: 12px;
		color: #909399;
		text-transform: uppercase;
	}
	
	input {
		display: block;
		width: 100%;
		margin-top: 5px;
		padding-bottom: 5px;
		font-size: 16px;
		border-bottom: 1px solid rgba(0, 0, 0, 0.4);
		text-align: center;
	}

	.tip {
		font-size: 20px;
		margin: 40px auto 50px;
		text-align: center;
	}

	.content {
		overflow: hidden;
		position: absolute;
		left: 50%;
		top: 50%;
		width: 900px;
		height: 550px;
		margin: -300px 0 0 -450px;
		background: #fff;
	}

	.form {
		position: relative;
		width: 640px;
		height: 100%;
		transition: -webkit-transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
		padding: 50px 30px 0;
	}

	.sub-cont {
		overflow: hidden;
		position: absolute;
		left: 640px;
		top: 0;
		width: 900px;
		height: 100%;
		padding-left: 260px;
		background: #fff;
		transition: -webkit-transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
	}

	.content.s--signup .sub-cont {
		-webkit-transform: translate3d(-640px, 0, 0);
		transform: translate3d(-640px, 0, 0);
	}



	.img {
		overflow: hidden;
		z-index: 2;
		position: absolute;
		left: 0;
		top: 0;
		width: 260px;
		height: 100%;
		padding-top: 360px;
	}

	.img:before {
		content: '';
		position: absolute;
		right: 0;
		top: 0;
		width: 900px;
		height: 100%;
		background-image: url("/img/back1.jpg");
		background-size: cover;
		transition: -webkit-transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
	}

	.img:after {
		content: '';
		position: absolute;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background: rgba(0, 0, 0, 0.6);
	}

	.content.s--signup .img:before {
		-webkit-transform: translate3d(640px, 0, 0);
		transform: translate3d(640px, 0, 0);
	}

	.img__text {
		z-index: 2;
		position: absolute;
		left: 0;
		top: 50px;
		width: 100%;
		padding: 0 20px;
		text-align: center;
		color: #fff;
		transition: -webkit-transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out;
		transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
	}

	.img__text h2 {
		margin-bottom: 10px;
		font-weight: normal;
	}

	.img__text p {
		font-size: 14px;
		line-height: 1.5;
	}

	.content.s--signup .img__text.m--up {
		-webkit-transform: translateX(520px);
		transform: translateX(520px);
	}

	.img__text.m--in {
		-webkit-transform: translateX(-520px);
		transform: translateX(-520px);
	}

	.content.s--signup .img__text.m--in {
		-webkit-transform: translateX(0);
		transform: translateX(0);
	}

	.img__btn {
		overflow: hidden;
		z-index: 2;
		position: relative;
		width: 100px;
		height: 36px;
		margin: 0 auto;
		background: transparent;
		color: #fff;
		text-transform: uppercase;
		font-size: 15px;
		cursor: pointer;
	}

	.img__btn:after {
		content: '';
		z-index: 2;
		position: absolute;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		border: 2px solid #fff;
		border-radius: 30px;
	}

	.img__btn span {
		position: absolute;
		left: 0;
		top: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 100%;
		transition: -webkit-transform 0.6s;
		transition: transform 0.6s;
		transition: transform 0.6s, -webkit-transform 0.6s;
	}

	.img__btn span.m--in {
		-webkit-transform: translateY(-72px);
		transform: translateY(-72px);
	}

	.content.s--signup .img__btn span.m--in {
		-webkit-transform: translateY(0);
		transform: translateY(0);
	}

	.content.s--signup .img__btn span.m--up {
		-webkit-transform: translateY(72px);
		transform: translateY(72px);
	}



	.forgot-pass {
		margin-top: 15px;
		text-align: center;
		font-size: 12px;
		color: #cfcfcf;
	}

	.forgot-pass a {
		color: #cfcfcf;
	}

	.submit {
		margin-top: 5px;
		margin-bottom: 20px;
		background: #30424c;
		text-transform: uppercase;
	}

	.fb-btn {
		border: 2px solid #d3dae9;
		color: #8fa1c7;
	}

	.fb-btn span {
		font-weight: bold;
		color: #455a81;
	}

	.sign-in {
		transition-timing-function: ease-out;
	}

	.content.s--signup .sign-in {
		transition-timing-function: ease-in-out;
		transition-duration: 0.6s;
		-webkit-transform: translate3d(640px, 0, 0);
		transform: translate3d(640px, 0, 0);
	}

	.sign-up {
		-webkit-transform: translate3d(-900px, 0, 0);
		transform: translate3d(-900px, 0, 0);
	}

	.content.s--signup .sign-up {
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}
</style>
