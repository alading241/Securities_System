/* 统一接口配置 */

const SERVERURL = 'http://www.xml626.cn:8081/';

const URL = {
  postMessage: `${SERVERURL}addForum`, // 提交帖子
  sendMessage: `${SERVERURL}sendMessage`, // 开户 发送验证码
  loginByMessagePost: `${SERVERURL}loginByMessagePost`, // 开户 提交表单信息
  getStockData: `${SERVERURL}getStockData`, // 获取股票日K图
  openUser: `${SERVERURL}openUser`, // 个人信息完善页面 提交用户信息表单
  login: `${SERVERURL}login`, // 登录验证
  getInitialization: `${SERVERURL}getInitialization`, // 获取热门股
  addReply: '{SERVERURL}addReply', // 提交评论
  delForum: '{SERVERURL}delForum', // 删除帖子
  delReply: '{SERVERURL}delReply', // 删除回复
  getForumByPostId: '{SERVERURL}getForumByPostId', // 获取帖子详情
  selectReply: '{SERVERURL}selectReply', // 获取帖子对应的评论
  getForumInfo: '{SERVERURL}getForumInfo', // 获取所有的帖子
  getHotForumInfo: '{SERVERURL}getHotForumInfo', // 获取所有的热门帖子
  getOwnForumInfo: '{SERVERURL}getOwnForumInfo', // 获取用户帖
};

export default URL;
