(window.webpackJsonp=window.webpackJsonp||[]).push([[19],{700:function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("section",{staticClass:"table-container"},[i("div",{staticClass:"toolbar"},[i("el-select",{attrs:{placeholder:"请选择省",clearable:""},on:{change:t.cityListGet},model:{value:t.provinceId,callback:function(e){t.provinceId=e},expression:"provinceId"}},t._l(t.locationPOptions,function(t,e){return i("el-option",{key:e,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),i("el-select",{attrs:{placeholder:"请选择市",clearable:""},model:{value:t.cityId,callback:function(e){t.cityId=e},expression:"cityId"}},t._l(t.locationCOptions,function(t,e){return i("el-option",{key:e,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"开始时间"},model:{value:t.startTime,callback:function(e){t.startTime=e},expression:"startTime"}}),t._v(" "),i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"结束时间"},model:{value:t.endTime,callback:function(e){t.endTime=e},expression:"endTime"}}),t._v(" "),i("el-button",{attrs:{icon:"el-icon-search"},on:{click:t.tableListGet}}),t._v(" "),i("div",{staticClass:"placeholder"}),t._v(" "),i("el-button",{attrs:{icon:"el-icon-download",type:"primary"},on:{click:t.exportExcel}},[t._v("导出")])],1),t._v(" "),i("div",{staticClass:"table"},[i("el-table",{attrs:{data:t.tableData}},[i("el-table-column",{attrs:{prop:"taskType",label:"巡查类型","min-width":"100",align:"center"}}),t._v(" "),i("el-table-column",{attrs:{prop:"staNum",label:"巡查站点数","min-width":"100",align:"center"}}),t._v(" "),i("el-table-column",{attrs:{prop:"patNum",label:"巡查次数","min-width":"100",align:"center"}})],1)],1)])};n._withStripped=!0;i(213);var l={data:function(){return{tableData:[],provinceId:null,cityId:null,startTime:null,endTime:null,locationPOptions:[],locationCOptions:[]}},methods:{tableListGet:function(){var t=this,e={parameters:{pid:this.provinceId||null,cid:this.cityId||null,start:this.startTime||null,end:this.endTime||null}};this.$API.StatisticInspectionGet(e).then(function(e){t.tableData=e})},cityListGet:function(){var t=this;this.cityId=null,this.$API.LocationGetC({pid:this.provinceId}).then(function(e){t.locationCOptions=e})},exportExcel:function(){var t={parameters:{pid:this.provinceId||null,cid:this.cityId||null,start:this.startTime||null,end:this.endTime||null}};this.$API.StatisticInspectionExport(t).then(function(t){var e=new Blob([t],{type:"application/vnd.ms-excel"}),i=window.URL.createObjectURL(e),n=document.createElement("a");n.href=i,n.download="Excel.xlsx",n.click(),window.URL.revokeObjectURL(i)})}},mounted:function(){var t=this;this.$API.LocationGetP().then(function(e){t.locationPOptions=e}),this.tableListGet()}},a=i(8),c=Object(a.a)(l,n,[],!1,null,null,null);c.options.__file="src/views/Statistic/Inspection.vue";e.default=c.exports}}]);