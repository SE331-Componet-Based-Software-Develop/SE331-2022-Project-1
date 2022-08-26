<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">Vaccine Management System Registration</h1>
                                                                  <el-form-item v-if="tableName=='yuangong'" label="Badge number" prop="yuangonggonghao">
        <el-input v-model="ruleForm.gonghao" placeholder="Badge number"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Name" prop="yuangongxingming">
        <el-input v-model="ruleForm.xingming" placeholder="Name"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Passport" prop="yuangongmima">
        <el-input v-model="ruleForm.mima" placeholder="Passport"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Age" prop="yuangongnianling">
        <el-input v-model="ruleForm.nianling" placeholder="Age"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Job Title" prop="yuangongzhicheng">
        <el-input v-model="ruleForm.zhicheng" placeholder="Job Title"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Phone Number" prop="yuangonglianxidianhua">
        <el-input v-model="ruleForm.lianxidianhua" placeholder="Phone Number"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="ID number" prop="yuangongshenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="ID number"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='yuangong'" label="Address" prop="yuangongjiatingzhuzhi">
        <el-input v-model="ruleForm.jiatingzhuzhi" placeholder="Address"></el-input>
      </el-form-item>
                                          <el-button @click="login()" class="btn-login" type="primary">Sign Up</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                                                                                                                                                                                                                                                                                                                                    if(`yuangong` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`Phone Number应输入电话格式`);
        return
      }
                                                                        if(`yuangong` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`ID number应输入ID number格式`);
        return
      }
                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
