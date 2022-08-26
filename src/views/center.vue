<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                                                                  <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Badge number" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" 
              placeholder="Badge number" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Name" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="Name" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Passport" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="Passport" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Age" prop="nianling">
          <el-input v-model="ruleForm.nianling" 
              placeholder="Age" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Job Title" prop="zhicheng">
          <el-input v-model="ruleForm.zhicheng" 
              placeholder="Job Title" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Phone Number" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="Phone Number" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="ID number" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="ID number" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="flag=='yuangong'"  label="Address" prop="jiatingzhuzhi">
          <el-input v-model="ruleForm.jiatingzhuzhi" 
              placeholder="Address" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-form-item v-if="flag=='users'" label="User Name" prop="username">
        <el-input v-model="ruleForm.username" 
        placeholder="User Name"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">revise</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，ID number校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                                                                                                                                  };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                                                                                      },
  methods: {
                                                                                                                                                                                                                                            onUpdateHandler() {
                                                                                                                                                                                                                                                                                                                                    if( 'yuangong' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`Phone Number should be entered in the Phone format`);
        return
      }
                                                                        if( 'yuangong' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`ID number should be entered in a valid format`);
        return
      }
                                                                                                this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Modifying the information successfully",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
