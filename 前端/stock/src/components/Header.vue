<!--头部-->
<template>
  <div class="top">
    <div class="top-context">
      <ul class="top-context-left">
        <li>欢迎来到证券交易！</li>
        <li>
          <router-link to="/login">{{phone}}</router-link>
        </li>
        <li>
          <router-link to="/reg">免费注册</router-link>
        </li>
      </ul>
      <div class="top-context-center"></div>
      <ul class="top-context-right">
        <li>
          <router-link to="/">网站首页</router-link>
        </li>
        <li>
          <a href="#" @click="addPost()">发帖子</a>
        </li>
        <li @click="exit" class="top-context-right-menu">
          <span class="menu">退出</span>
        </li>
      </ul>
    </div>
    <div class="posted" v-show="isTrue">
      <div class="dialog-box">
        <div class="dialog-box-title">
          <div class="dialog-box-title-header">
            <span>发表帖子</span>
            <span class="dialog-box-title-header-close" @click="close()">×</span>
          </div>
        </div>
        <div class="dialog-box-content">
          <h5>内容</h5>
          <textarea ref="postText" required v-model="addpostContent"></textarea>
        </div>
        <div v-show="enterContent" class="enterContent">请输入内容！</div>
        <div v-show="sensitive" class="sensitive">输入内容包含敏感词!</div>
        <div class="hint" v-if="isPosted">发表成功！</div>
        <div>
          <el-button
            :disabled="disabledBtn"
            type="primary"
            @click.prevent="submit()"
            :loading="loading"
          >{{Submit?'提交中':'确定'}}</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState, mapMutations } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  inject: ["reload"],
  data() {
    return {
      stock_id: "", //股票代码
      disabledBtn: "disabled", //提交按钮是否可用
      Submit: false, //提交帖子的按钮的内容
      isTrue: false, //显示对话框
      isPosted: false, //是否显示'发表成功'
      loading: false, //显示正在提交中
      addpostContent: "", //发帖子内容
      myPost: [],
      enterContent: false, //是否显示输入内容
      sensitive: false //敏感词提示
    };
  },
  watch: {
    //监测文本框内容
    addpostContent: function() {
      var words = this.sensitiveWords(this.addpostContent); //敏感词监测
      var reg = "^[ ]+$";
      var re = new RegExp(reg);
      if (
        //文本框必须输入内容
        this.addpostContent == "" ||
        this.addpostContent.length == 0 ||
        re.test(this.addpostContent) == true
      ) {
        this.enterContent = true;
        this.disabledBtn = "disabled";
      } else if (!words) {
        //没有敏感词
        this.sensitive = true;
        this.disabledBtn = "disabled";
        this.enterContent = false;
      } else {
        this.enterContent = false;
        this.disabledBtn = null;
        this.sensitive = false;
      }
    }
  },
  created() {
    this.stock_id = this.$route.params.id;
    this.localLogin(localStorage.phone);
  },
  computed: {
    ...mapState(["phone"])
  },
  methods: {
    ...mapMutations(["exitLogin"]),
    ...mapMutations(["localLogin"]),
    close() {
      this.isTrue = false;
    },
    //提交帖子
    submit() {
      axios({
        url: URL.postMessage,
        method: "post",
        params: {
          post_title: this.addpostContent,
          post_text: this.addpostContent,
          user_name: this.phone,
          stock_id: this.stock_id
        }
      })
        .then(res => {
          console.log(res);
          if (res.status == 200) {
            this.loading = true;
            this.Submit = true;
            this.$refs.postText.disabled = "disabled";
            setTimeout(() => {
              this.isPosted = true;
              this.loading = false;
              this.Submit = false;
            }, 2000);
            setTimeout(() => {
              this.isTrue = false;
              this.addpostContent = "";
              this.isPosted = false;
              this.$refs.postText.disabled = "";
              this.$router.go(0);
            }, 4000);
          } else {
            alert("服务器错误！");
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    //发帖子
    addPost() {
      if (JSON.stringify(this.userInfo) === "{}") {
        this.$message({
          message: "请先登录！3秒后自动跳转",
          type: "warning"
        });
        setTimeout(() => {
          this.$router.push("/login");
        }, 1000);
      } else {
        this.isTrue = true;
      }
    },
    //敏感词处理
    sensitiveWords(str) {
      var Words = ["笨蛋", "傻", "杀", "神经病"];
      var re = "";
      for (var i = 0; i < Words.length; i++) {
        if (i == Words.length - 1) re += Words[i];
        else re += Words[i] + "|";
      }
      var pattern = new RegExp(re, "g");
      var res = pattern.test(str);
      if (res) {
        return false;
      } else {
        return true;
      }
    },
    exit() {
      if (this.phone != "未登录") {
        alert("退出成功！");
        this.exitLogin();
        this.reload();
      } else {
        alert("尚未登陆！");
      }
    }
  }
};
</script>

<style scoped lang="scss">
.top {
  z-index: 999;
  position: fixed;
  width: 100%;
  height: 3rem;
  box-shadow: 0 4px 4px #e6e6e6;
  background-color: #ffffff;
  &-context {
    width: 1000px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    &-left {
      width: 28%;
      height: 100%;
      flex: 1;
      li {
        float: left;
        padding: 0.5rem;
        a:hover {
          color: orange;
        }
      }
    }
    &-center {
      height: 100%;
      flex: 1;
    }
    &-right {
      width: 30%;
      height: 100%;
      flex: 0.8;
      li {
        float: left;
        padding: 0.5rem;
        img {
          width: 10px;
          height: 10px;
        }
        a:hover {
          color: orange;
        }
      }
      &-menu {
        a:hover {
          color: orange;
        }
        &-menu:hover {
          ul {
            display: block;
          }
          img {
            transform: rotate(90deg);
            transition: transform 0.2s;
          }
        }
        &-list {
          border: 1px solid #ccc;
          background: #ffffff;
          border-top: 0;
          position: absolute;
          top: 36px;
          right: 255px;
          width: 100px;
          display: none;
          li {
            padding: 0 14px;
          }
        }
      }
    }
  }

  a {
    color: #6c6c6c;
  }
}
.posted {
  z-index: 99999;
  clear: both;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
}
.dialog-box {
  width: 500px;
  height: 320px;
  border: 2px solid #808080;
  position: absolute;
  left: 50%;
  top: 50%;
  background-color: #fff;
  transform: translate(-50%, -50%);

  &-title {
    height: 40px;
    background-color: #ff8040;
    color: #000000;
    line-height: 40px;
    font-weight: bold;
    padding: 0 10px;
    font-size: 18px;
    &-header {
      float: left;
      cursor: pointer;
      position: relative;
      width: 100%;
      &-close {
        position: absolute;
        right: 10px;
        font-size: 30px;
        cursor: pointer;
        color: #000000;
        line-height: 40px;
        font-weight: bold;
        text-align: center;
      }
    }
  }
  &-content {
    width: 450px;
    margin: 0 auto;
    height: 180px;
    textarea {
      width: 450px;
      height: 150px;
    }
  }
}

.el-button {
  float: right;
}
.enterContent,
.hint,
.sensitive {
  width: 100%;
  color: #ff8040;
  font-weight: bold;
}
.register .login {
  margin-left: 20px;
}
</style>
