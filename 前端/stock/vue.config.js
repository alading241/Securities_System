const path = require("path");

module.exports = {
  devServer: {
    port: 8080,
    open: false, //是否自动打开
    disableHostCheck: true
  },
  lintOnSave: false,
  productionSourceMap: false, //打包不生成map文件

};
