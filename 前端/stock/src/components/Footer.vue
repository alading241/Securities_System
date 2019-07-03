<!--页面底部-->
<template>
  <div class="footer">
    <div class="footer-server">
      <ul>
        <li>
          <router-link to>关于我们</router-link>
        </li>
        <li>
          <router-link to>广告服务</router-link>
        </li>
        <li>
          <router-link to>联系我们</router-link>
        </li>
        <li>
          <router-link to>诚聘英才</router-link>
        </li>
        <li>
          <router-link to>免责声明</router-link>
        </li>
        <li>
          <router-link to>法律声明</router-link>
        </li>
        <li>
          <router-link to>隐私保护</router-link>
        </li>
        <li>
          <router-link to>征稿启事</router-link>
        </li>
        <li>
          <router-link to>网站地图</router-link>
        </li>
        <li>
          <router-link to>放心搜</router-link>
        </li>
        <li>
          <router-link to>友情链接</router-link>
        </li>
      </ul>
    </div>
    <div class="footer-letter">
      信息网络传播视听节目许可证：0908328号 经营证券期货业务许可证编号：913101046312860336 违法和不良信息举报:021-34289898 举报邮箱：
      <router-link to>jubao@eastmoney.com</router-link>
      <br />沪ICP证:沪B2-20070217 网站备案号:沪ICP备05006054号-11 沪公网安备 31010402000120号 版权所有:东方财富网 意见与建议:021-54509966/021-24099099
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer",
};
</script>
<style scoped lang="scss">
.footer {
  height: 10rem;
  margin-top: 10px;
  &-letter {
    height: 5rem;
    font-size: 12px;
    text-align: center;
    line-height: 2rem;
    padding-top: 5px;
    a {
      color: blue;
    }
  }
  &-server {
    height: 3rem;
    background: #2f5895;
    line-height: 3rem;
    ul {
      display: flex;
      li {
        flex: 1;
        text-align: center;
        a {
          color: white;
        }
        a:hover {
          text-decoration: underline;
        }
      }
    }
  }
}
</style>
