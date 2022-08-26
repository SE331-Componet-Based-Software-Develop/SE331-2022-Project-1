<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="Vaccine number">
                <el-input v-model="searchForm.yimiaobianhao" 
                    placeholder="Vaccine number" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="Vaccine name">
                <el-input v-model="searchForm.yimiaomingcheng" 
                    placeholder="Vaccine name" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="Vaccine Type">
                <el-input v-model="searchForm.yimiaoleixing" 
                    placeholder="Vaccine Type" clearable></el-input>
              </el-form-item>
                                                                                            <el-form-item>
          <el-button round @click="search()">Query</el-button>
          <el-button
            v-if="isAuth('yimiaomingcheng','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >Add</el-button>
          <el-button
            v-if="isAuth('yimiaomingcheng','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >Delete</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('yimiaomingcheng','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="yimiaobianhao"
                    header-align="center"
                    align="center"
                    sortable
                    label="Vaccine number">
                    <template slot-scope="scope">
                      {{scope.row.yimiaobianhao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yimiaomingcheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="Vaccine name">
                    <template slot-scope="scope">
                      {{scope.row.yimiaomingcheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yimiaoleixing"
                    header-align="center"
                    align="center"
                    sortable
                    label="Vaccine Type">
                    <template slot-scope="scope">
                      {{scope.row.yimiaoleixing}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="kucunshuliang"
                    header-align="center"
                    align="center"
                    sortable
                    label="Inventory quantity">
                    <template slot-scope="scope">
                      {{scope.row.kucunshuliang}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jiezhongnianling"
                    header-align="center"
                    align="center"
                    sortable
                    label="Vaccination age">
                    <template slot-scope="scope">
                      {{scope.row.jiezhongnianling}}
                    </template>
                </el-table-column>
                                                                                                <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('yimiaomingcheng','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">Details</el-button>
                                                <el-button v-if="isAuth('yimiaomingcheng','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">Updata</el-button>
                <el-button v-if="isAuth('yimiaomingcheng','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">Delete</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

    
    
    
  </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
                                                                                          yimiaoleixingOptions: [],
                                                                              searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
          };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
      },
  methods: {
                init () {
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
                                                                                                                          let urlkucunshuliang = 'yimiaomingcheng/remind/kucunshuliang/1?1=1';
                      urlkucunshuliang+=`&remindend=10`,
                                urlkucunshuliang+=`&remindstart=0`,
                    this.$http({
            url: urlkucunshuliang,
            method: "get",
          }).then(({ data }) => {
            if (data && data.code == 0 && data.count>0 ) {
              this.$alert(`库存数量有${data.count}条记录到达预警`)
            }
          });
                                              },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                          if(this.searchForm.yimiaobianhao!='' && this.searchForm.yimiaobianhao!=undefined){
            params['yimiaobianhao'] = '%' + this.searchForm.yimiaobianhao + '%'
          }
                                                            if(this.searchForm.yimiaomingcheng!='' && this.searchForm.yimiaomingcheng!=undefined){
            params['yimiaomingcheng'] = '%' + this.searchForm.yimiaomingcheng + '%'
          }
                                                            if(this.searchForm.yimiaoleixing!='' && this.searchForm.yimiaoleixing!=undefined){
            params['yimiaoleixing'] = '%' + this.searchForm.yimiaoleixing + '%'
          }
                                                                                                this.$http({
        url: "yimiaomingcheng/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "yimiaomingcheng/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
