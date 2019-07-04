<!--自选股-->
<template>
  <div class="myStock">
    <ul v-for="(item,index) in selectStock" :key="index">
      <li @click="detail(item.stock_id,item.stock_name)">
        <div class="myStock-info">
          <span>{{item.stock_name}}</span>
          <span class="myStock-info-id">{{item.stock_id}}</span>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
import { setTimeout, setInterval } from "timers";
import { mapState, mapMutations } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  computed: {
    ...mapState(["phone"])
  },
  created() {
    setInterval(() => {
      axios({
        url: URL.selectOptionalStock,
        method: "get",
        params: {
          phone: this.phone
        }
      })
        .then(res => {
          this.selectStock = res.data;
        })
        .catch(err => {});
    }, 5000);
  },
  data() {
    return {
      selectStock: [],
      num: 1
    };
  },
  computed: {
    ...mapState(["phone"])
  },
  methods: {
    //选中股票
    detail(id, name) {
      setTimeout(() => {
        this.$router.push("/stockdetails/" + id);
      }, 1000);
    }
  }
};
</script>
<style scoped lang="scss">
.myStock {
  &-info {
    width: 80%;
    float: left;
    padding-left: 10px;
    span {
      color: blue;
    }
    &-id {
      float: right;
    }
  }
  &-data {
    width: 65%;
    text-align: right;
    margin-left: 30%;
    color: green;
  }
}
</style>
