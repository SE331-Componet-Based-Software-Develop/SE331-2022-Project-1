<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="ID" prop="gonghao">
          <el-input v-model="ruleForm.gonghao" 
              placeholder="ID" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gonghao" label="ID" prop="gonghao">
              <el-input v-model="ruleForm.gonghao" 
                placeholder="ID" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Name" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="Name" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xingming" label="Name" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="Name" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Passport" prop="mima">
          <el-input v-model="ruleForm.mima" 
              placeholder="Passport" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.mima" label="Passport" prop="mima">
              <el-input v-model="ruleForm.mima" 
                placeholder="Passport" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Age" prop="nianling">
          <el-input v-model="ruleForm.nianling" 
              placeholder="Age" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.nianling" label="Age" prop="nianling">
              <el-input v-model="ruleForm.nianling" 
                placeholder="Age" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Title" prop="zhicheng">
          <el-input v-model="ruleForm.zhicheng" 
              placeholder="Title" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhicheng" label="Title" prop="zhicheng">
              <el-input v-model="ruleForm.zhicheng" 
                placeholder="Title" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Phone Number" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="Phone Number" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.lianxidianhua" label="Phone Number" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="Phone Number" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="IDCard" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="IDCard" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenfenzheng" label="IDCard" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="IDCard" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Address" prop="jiatingzhuzhi">
          <el-input v-model="ruleForm.jiatingzhuzhi" 
              placeholder="Address" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiatingzhuzhi" label="Address" prop="jiatingzhuzhi">
              <el-input v-model="ruleForm.jiatingzhuzhi" 
                placeholder="Address" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                  </el-row>
                                                                                                                                                                                                                                                  <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">Yes</el-button>
        <el-button v-if="type!='info'" @click="back()">No</el-button>
        <el-button v-if="type=='info'" @click="back()">Back</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
      ruleForm: {
                        gonghao: '',
                                xingming: '',
                                mima: '',
                                nianling: '',
                                zhicheng: '',
                                lianxidianhua: '',
                                shenfenzheng: '',
                                jiatingzhuzhi: '',
                      },
                                                                                                                            rules: {
                  gonghao: [
                                                                                              ],
                  xingming: [
                                                                                              ],
                  mima: [
                                                                                              ],
                  nianling: [
                                                                                              ],
                  zhicheng: [
                                                                                              ],
                  lianxidianhua: [
                                                                { validator: validatePhone, trigger: 'blur' },
                                                          ],
                  shenfenzheng: [
                                                                                        { validator: validateIdCard, trigger: 'blur' },
                                  ],
                  jiatingzhuzhi: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                      },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='gonghao'){
            this.ruleForm.gonghao = obj[o];
            continue;
          }
                    if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
            continue;
          }
                    if(o=='mima'){
            this.ruleForm.mima = obj[o];
            continue;
          }
                    if(o=='nianling'){
            this.ruleForm.nianling = obj[o];
            continue;
          }
                    if(o=='zhicheng'){
            this.ruleForm.zhicheng = obj[o];
            continue;
          }
                    if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
            continue;
          }
                    if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
            continue;
          }
                    if(o=='jiatingzhuzhi'){
            this.ruleForm.jiatingzhuzhi = obj[o];
            continue;
          }
                  }
                                                                                                                                              }
                                                                                                                                                                              },
                                                                        // 多级联动参数
                                                                                            info(id) {
      this.$http({
        url: `yuangong/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                                                                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yuangong/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.yuangongCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yuangongCrossAddOrUpdateFlag = false;
    },
                                                                                                      }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
