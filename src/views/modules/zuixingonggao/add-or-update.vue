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
        <el-form-item v-if="type!='info'" label="NO." prop="bianhao">
            <el-input v-model="ruleForm.bianhao" 
                placeholder="NO." readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.bianhao" label="NO." prop="bianhao">
              <el-input v-model="ruleForm.bianhao" 
                placeholder="NO." readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="Title" prop="biaoti">
          <el-input v-model="ruleForm.biaoti" 
              placeholder="Title" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.biaoti" label="Title" prop="biaoti">
              <el-input v-model="ruleForm.biaoti" 
                placeholder="Title" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="Image" prop="tupian">
          <file-upload
          tip="Click Upload image"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="Image" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="Date" prop="fabushijian">
            <el-date-picker
                format="yyyy. MM. dd"
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.fabushijian" 
                type="date"
                placeholder="Date">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fabushijian" label="Date" prop="fabushijian">
              <el-input v-model="ruleForm.fabushijian" 
                placeholder="Date" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                  </el-row>
                                                                                                                                              <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="content" prop="neirong">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.neirong" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.neirong" label="content" prop="neirong">
                    <span v-html="ruleForm.neirong"></span>
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
                        bianhao: this.getUUID(),
                                biaoti: '',
                                tupian: '',
                                neirong: '',
                                fabushijian: '',
                      },
                                                                                  rules: {
                  bianhao: [
                                                                                              ],
                  biaoti: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  neirong: [
                                                                                              ],
                  fabushijian: [
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
                    if(o=='bianhao'){
            this.ruleForm.bianhao = obj[o];
            continue;
          }
                    if(o=='biaoti'){
            this.ruleForm.biaoti = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='neirong'){
            this.ruleForm.neirong = obj[o];
            continue;
          }
                    if(o=='fabushijian'){
            this.ruleForm.fabushijian = obj[o];
            continue;
          }
                  }
                                                                                              }
                                                                                                                        },
                                                // ??????????????????
                                                              info(id) {
      this.$http({
        url: `zuixingonggao/info/${id}`,
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
            url: `zuixingonggao/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.zuixingonggaoCrossAddOrUpdateFlag = false;
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
      this.parent.zuixingonggaoCrossAddOrUpdateFlag = false;
    },
                                                tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
            },
                                      }
};
</script>
<style lang="scss" scoped>
.editor{
  height: 500px;
}
</style>
