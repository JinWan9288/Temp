<template>
  <div class="home">
    <el-container style="height: 500px; border: 2px solid #eee">
      <el-aside width="200px" style=" height: 600px ; background-color: rgb(238, 241, 246) ">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100% " background-color="rgb(48,65,86)"
        text-color="#fff" active-text-color="#ffd04b"  :collapse-transition="false"
        box-shadow:2px  >
          <div style="height: 60px; line-height: 60px;text-align: center">
            <img src="../assets/logo.png" style="width: 20px; position: relative">
            <b style="color: azure" v-show="LogoTextShow">后台管理系统</b>
          </div>

          <!--导航栏-->
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>
              <span slot="title">用户管理</span></template>
            <el-menu-item-group>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>导航二</template>
            <el-menu-item-group>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>导航三</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item><b @click="AddUser">新增</b></el-dropdown-item>
              <el-dropdown-item><b @click="handleDeleteBatch">删除</b></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>
        <!--搜索栏-->
        <div>
          <el-input style="width: 250px" placeholder="请输入用户姓名" suffix-icon="el-icon-search" v-model="username" ></el-input>
          <el-input style="width: 250px" class="ml-10" suffix-icon="el-icon-position" placeholder="请输入地址"
                    v-model="address"></el-input>
          <el-input style="width: 250px;margin-bottom: 20px" class="ml-10" suffix-icon="el-icon-message"
                    placeholder="请输入邮箱 " v-model="email"></el-input>
          <el-button class="ml-20" type="success" round  @click="load">  搜索   <i class="el-icon-loading"></i></el-button>
          <el-button class="ml-30" type="warning" round @click="reset">  重置   <i class="el-icon-refresh"></i></el-button>
          <!-- 点击后就进行分页查询 load  @click 点击后就... --> <br/>
          <el-button class="ml-20" type="primary"  @click="AddUser">  新增  <i class="el-icon-circle-plus"></i></el-button>
          <el-popconfirm
              class="ml-10"
              confirm-button-text='是的'
              cancel-button-text='不用了'
              icon="el-icon-info"
              icon-color="red"
              title="您确定批量删除这些用户吗？"
              @confirm="handleDeleteBatch">
            <el-button class="ml-10" type="danger" slot="reference">批量删除<i class="el-icon-remove-outline">
            </i></el-button> </el-popconfirm>

          <el-button class="ml-20" type="primary">导入   <i class="el-icon-download"></i></el-button>
          <el-button class="ml-20" type="primary">导出   <i class="el-icon-upload2"></i></el-button>
        </div>

        <el-main>
          <el-table :data="tableData" border stripe :header-cell-class-name="headerBg"
                    @selection-change="handleSelectionChange"> <!-- 点击复选框后发生的事件 -->
            <el-table-column type="selection" width="40"></el-table-column>
            <el-table-column prop="id" label="id" width="35">
            </el-table-column>
            <el-table-column prop="username" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="nickname" label="昵称" width="80">
          </el-table-column>
            <el-table-column prop="age" label="年龄" width="50">
            </el-table-column>
            <el-table-column prop="sex" label="性别" width="50">
            </el-table-column>
            <el-table-column prop="phone" label="电话号码" width="100">
            </el-table-column>
            <el-table-column prop="address" label="地址" >
            </el-table-column>
            <el-table-column prop="email" label="邮箱" width="120">
            </el-table-column>
            <el-table-column prop="roleId" label="身份" width="60">
            </el-table-column>
            <el-table-column prop="isvalid" label="是否有效" width="70">
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="140">
            </el-table-column>

            <el-table-column label="操作" width="180"> <!--  操作列  -->
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    @click="handleEdit(scope.row)">编辑    <i class="el-icon-edit-outline"></i></el-button>

                <el-popconfirm
                    class="ml-10"
                    confirm-button-text='是的'
                    cancel-button-text='不用了'
                    icon="el-icon-info"
                    icon-color="red"
                    title="您确定删除这个用户吗？"
                    @confirm="handleDelete(scope.row.id)">
                  <el-button size="mini" type="danger" slot="reference"> 删除
                    <i class="el-icon-delete-solid"></i></el-button> </el-popconfirm>
                                              <!--加上 slot reference 才能看见这个按钮   专门用来触发 Popconfirm 显示-->
              </template>
            </el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </el-container>

    <!-- Form -->
    <el-dialog title="请填写新增用户信息" :visible.sync="dialogFormVisible" position="fixed">
      <el-form>
        <el-form-item label="用户姓名" :label-width="formLabelWidth">
          <el-input v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户昵称" :label-width="formLabelWidth">
          <el-input v-model="form.nickname" autocomplete="off"></el-input>
        </el-form-item>
        <!--              <el-form-item label="请设置用户密码" :label-width="formLabelWidth">-->
        <!--                <el-input v-model="form.passwords" autocomplete="off"></el-input>  &lt;!&ndash;  密码要加密&ndash;&gt;-->
        <!--              </el-form-item>-->
        <el-form-item label="年龄" :label-width="formLabelWidth">
          <el-input v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-select v-model="form.sex" placeholder="请选择用户性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select> </el-form-item>
        <el-form-item label="电话号码" :label-width="formLabelWidth">
          <el-input v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户家庭住址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电子邮箱" :label-width="formLabelWidth">
          <el-input v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户身份" :label-width="formLabelWidth">
          <el-input v-model="form.roleId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上传用户头像" :label-width="formLabelWidth">
          <el-input v-model="form.avatarurl" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
    <span class="demonstration">
      <br/>
    </span>
    <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[2, 5, 7 , 10, 20]"
        :page-size="pageSize"
        layout="sizes, prev, pager, next"
        :total="total"
        :address="address"
        :email="email">
     </el-pagination> <!--      绑定后端传来的total-->

  </div>
</template>

<script>

import HelloWorld from '@/components/HelloWorld.vue'
import request from "@/Utils/request";

export default {
  name: 'HomeView',
  data() {

    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      username: "",
      address: "",
      email: "",
      nickname:"",
      age:"",
      sex:"",
      phone:"",
      roleId:1,
      isvaild:"Y",
      passwords:"",
      avatarurl:"",
      form:{},
      multipleSelection: [], // 选择的数据条 数据行
      dialogFormVisible: false,  //弹窗初始不可见
      formLabelWidth: '120px',

      LogoTextShow: true,
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4,
      headerBg: "headerBg",
    }
  },

  created() {
    // 请求分页查询数据 第一个参数 url
    this.load();
  },

  methods: {
    load() {
      // mybatis plus 使用request实现分页查询
      request.get("/user/pageMbP", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          address: this.address,
          email: this.email
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.records
        this.total = res.total
      });

      // 请求分页查询数据 第一个参数 url mybatis写法
      // fetch( "http://localhost:9090/user/page?pageNum= "
      //     + this.pageNum + "&pageSize=" + this.pageSize + "&username="+ this.username)
      //     .then(res => res.json() ).then(res => {
      //   console.log(res);
      //   this.tableData = res.data;  // 将前端的数据传入后端
      //   this.total =res.total;
      //   console.log(res.total);
      // });
    },

    reset() {
      this.username = "";
      this.address = "";
      this.email = "";
      this.load();
    },
    AddUser(){
      this.dialogFormVisible = true;
      this.form ={};
    },
    save(){
      request.post("/user",this.form).then(res => {
        if(res){ // 传入数据
          this.$message.success("保存成功 !")
          this.dialogFormVisible = false
          this.load()
        }else { this.$message.error("保存失败 !")}
      })
    },
    handleSelectionChange(val){ // 只是加复选框
      console.log(val) // val就是选择的数据的数组
      this.multipleSelection =val  // 把数组给 multipleSelection
    },
    handleEdit(row) {
      this.form = row; // 把当行的数据赋予到弹窗中
      this.dialogFormVisible = true; //打开弹窗
      console.log(row);
    },
    handleDelete(id) {
      request.delete("/user/"+ id).then(res => {
        if(res){ // 传入数据
          this.$message.success("删除成功 !")
          this.dialogFormVisible = false
          this.load()
        }else { this.$message.error("删除失败 !")}
      })
      console.log(id);
    },
    handleDeleteBatch() { //对multipleSelection对象进行处理
      let ids = this.multipleSelection.map(v => v.id)  // 扁平化处理 将一个对象变成一个纯id 只有id 的 数组     [{1,},{2,},{3,}] -> [1,2,3]
      request.post("/user/del/batch", ids).then(res => {
        if(res){ // 传入数据
          this.$message.success("删除成功 !")
          this.dialogFormVisible = false
          this.load()
        }else { this.$message.error("删除失败 !")}
      })
    },
    handleSizeChange(pageSize){
      console.log(`每页 ${pageSize} 条`);
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum){
      console.log(`当前页码: ${pageNum}`);
      this.pageNum = pageNum;
      this.load();
    },
  }
}
</script>
<style>
.headerBg{
  background:azure!important;
}
</style>