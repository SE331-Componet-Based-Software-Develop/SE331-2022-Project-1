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
        <el-form-item v-if="type!='info'" label="Vaccine number" prop="yimiaobianhao">
            <el-input v-model="ruleForm.yimiaobianhao" 
                placeholder="Vaccine number" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yimiaobianhao" label="Vaccine number" prop="yimiaobianhao">
              <el-input v-model="ruleForm.yimiaobianhao" 
                placeholder="Vaccine number" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Vaccine name" prop="yimiaomingcheng">
          <el-input v-model="ruleForm.yimiaomingcheng" 
              placeholder="Vaccine name" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yimiaomingcheng" label="Vaccine name" prop="yimiaomingcheng">
              <el-input v-model="ruleForm.yimiaomingcheng" 
                placeholder="Vaccine name" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="Vaccine Type" prop="yimiaoleixing">
          <el-select v-model="ruleForm.yimiaoleixing" placeholder="Please select the type of vaccine">
            <el-option
                v-for="(item,index) in yimiaoleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yimiaoleixing" label="Vaccine Type" prop="yimiaoleixing">
              <el-input v-model="ruleForm.yimiaoleixing" 
                placeholder="Vaccine Type" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Inventory quantity" prop="kucunshuliang">
          <el-input v-model="ruleForm.kucunshuliang" 
              placeholder="Inventory quantity" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kucunshuliang" label="Inventory quantity" prop="kucunshuliang">
              <el-input v-model="ruleForm.kucunshuliang" 
                placeholder="Inventory quantity" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Vaccination age" prop="jiezhongnianling">
          <el-input v-model="ruleForm.jiezhongnianling" 
              placeholder="Vaccination age" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiezhongnianling" label="Vaccination age" prop="jiezhongnianling">
              <el-input v-model="ruleForm.jiezhongnianling" 
                placeholder="Vaccination age" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    </el-row>
                                                                                                                                                                                        <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="details" prop="xiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.xiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xiangqing" label="details" prop="xiangqing">
                    <span v-html="ruleForm.xiangqing"></span>
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
// ???????????????????????????url??????????????????
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("?????????????????????????????????"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("??????????????????URL??????"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("??????????????????????????????"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("??????????????????????????????"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("???????????????"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("???????????????"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
      ruleForm: {
                        yimiaobianhao: this.getUUID(),
                                yimiaomingcheng: '',
                                yimiaoleixing: '',
                                kucunshuliang: '',
                                jiezhongnianling: '',
                                xiangqing: '',
                      },
                                                    yimiaoleixingOptions: [],
                                                              rules: {
                  yimiaobianhao: [
                                                                                              ],
                  yimiaomingcheng: [
                                                                                              ],
                  yimiaoleixing: [
                                                                                              ],
                  kucunshuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  jiezhongnianling: [
                                                                                              ],
                  xiangqing: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                              },
  methods: {
    // ??????
    download(file){
      window.open(`${file}`)
    },
    // ?????????
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
                    if(o=='yimiaobianhao'){
            this.ruleForm.yimiaobianhao = obj[o];
            continue;
          }
                    if(o=='yimiaomingcheng'){
            this.ruleForm.yimiaomingcheng = obj[o];
            continue;
          }
                    if(o=='yimiaoleixing'){
            this.ruleForm.yimiaoleixing = obj[o];
            continue;
          }
                    if(o=='kucunshuliang'){
            this.ruleForm.kucunshuliang = obj[o];
            continue;
          }
                    if(o=='jiezhongnianling'){
            this.ruleForm.jiezhongnianling = obj[o];
            continue;
          }
                    if(o=='xiangqing'){
            this.ruleForm.xiangqing = obj[o];
            continue;
          }
                  }
                                                                                                              }
                                                                              this.$http({
              url: `option/yimiaoleixing/yimiaoleixing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.yimiaoleixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                  },
                                                        // ??????????????????
                                                                        info(id) {
      this.$http({
        url: `yimiaomingcheng/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // ??????
    onSubmit() {
                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yimiaomingcheng/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "????????????",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.yimiaomingchengCrossAddOrUpdateFlag = false;
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
    // ??????uuid
    getUUID () {
      return new Date().getTime();
    },
    // ??????
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yimiaomingchengCrossAddOrUpdateFlag = false;
    },
                                                                              }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
