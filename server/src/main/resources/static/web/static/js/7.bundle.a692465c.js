(window.webpackJsonp=window.webpackJsonp||[]).push([[7],{285:function(t,e,i){},697:function(t,e,i){"use strict";var n=i(285);i.n(n).a},708:function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("section",{staticClass:"table-container"},[i("div",{staticClass:"toolbar"},[i("el-select",{attrs:{placeholder:"请选择省",clearable:""},on:{change:t.cityListGet},model:{value:t.provinceId,callback:function(e){t.provinceId=e},expression:"provinceId"}},t._l(t.locationPOptions,function(t,e){return i("el-option",{key:e,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),i("el-select",{attrs:{placeholder:"请选择市",clearable:""},model:{value:t.cityId,callback:function(e){t.cityId=e},expression:"cityId"}},t._l(t.locationCOptions,function(t,e){return i("el-option",{key:e,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"开始时间"},model:{value:t.startTime,callback:function(e){t.startTime=e},expression:"startTime"}}),t._v(" "),i("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd hh:mm:ss",placeholder:"结束时间"},model:{value:t.endTime,callback:function(e){t.endTime=e},expression:"endTime"}}),t._v(" "),i("el-button",{attrs:{icon:"el-icon-search"},on:{click:t.tableListGet}}),t._v(" "),i("div",{staticClass:"placeholder"}),t._v(" "),i("el-button",{attrs:{icon:"el-icon-pie-chart"},on:{click:function(e){t.visible.chartDlg=!0}}},[t._v("图表")]),t._v(" "),i("el-button",{attrs:{icon:"el-icon-download",type:"primary"},on:{click:t.exportExcel}},[t._v("导出")])],1),t._v(" "),i("div",{staticClass:"card-box"},[i("el-card",{staticClass:"card"},[i("div",{attrs:{slot:"header"},slot:"header"},[i("span",[t._v("售后类型")])]),t._v(" "),t._l(t.menu.first.list,function(e){return i("div",{key:e.id,staticClass:"item",class:{"item-active":t.menu.first.id===e.id},on:{click:function(i){return t.handleMenuFirstClick(e.id)}}},[i("div",{staticClass:"item-text"},[t._v(t._s(e.name))]),t._v(" "),i("div",[t._v("\n\t\t\t\t\t"+t._s(e.num)+"次\n\t\t\t\t")])])})],2),t._v(" "),i("el-card",{staticClass:"card"},[i("div",{attrs:{slot:"header"},slot:"header"},[i("span",[t._v("故障设备")])]),t._v(" "),t._l(t.menu.second.list,function(e){return i("div",{key:e.id,staticClass:"item",class:{"item-active":t.menu.second.id===e.id},on:{click:function(i){return t.handleMenuSecondClick(e.id)}}},[i("div",{staticClass:"item-text"},[t._v(t._s(e.name))]),t._v(" "),i("div",[t._v("\n\t\t\t\t\t"+t._s(e.num)+"次\n\t\t\t\t")])])})],2)],1),t._v(" "),i("el-dialog",{attrs:{title:"饼状图",visible:t.visible.chartDlg,"close-on-click-modal":!1},on:{"update:visible":function(e){return t.$set(t.visible,"chartDlg",e)},opened:t.showChart}},[i("div",{ref:"chart",staticStyle:{width:"800px",height:"400px"}}),t._v(" "),i("div",{attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.visible.chartDlg=!1}}},[t._v("关 闭")])],1)])],1)};n._withStripped=!0;var s=i(213),l=i.n(s),a={data:function(){return{tableData:[],provinceId:null,cityId:null,startTime:null,endTime:null,type:null,locationPOptions:[],locationCOptions:[],tableParams:{parameter:null},visible:{menuAdd1:!1,menuAdd2:!1,menuEdit1:!1,menuEdit2:!1,chartDlg:!1},menuAddName:null,menuEditId:null,menuEditName:null,menu:{first:{id:0,name:null,list:[]},second:{id:0,name:null,list:[]}},menuIndex:{},menuLevel:1}},methods:{tableListGet:function(){var t=this,e={parameters:{pid:this.provinceId||null,cid:this.cityId||null,start:this.startTime||null,end:this.endTime||null,type:this.type||null}};this.$API.StatisticMaintainGet(e).then(function(e){t.menuIndex={},t.createMenuIndex(e),t.menu.first.list=e,t.menu.second.list=[]})},cityListGet:function(){var t=this;this.provinceId&&(this.cityId=null,this.$API.LocationGetC({pid:this.provinceId}).then(function(e){t.locationCOptions=e}))},showChart:function(){var t=[],e=[];if(this.menu.second.list&&0!==this.menu.second.list.length)for(var i in this.menu.second.list)t.push(this.menu.second.list[i].name),e.push({name:this.menu.second.list[i].name,value:this.menu.second.list[i].num});else for(var n in this.menu.first.list)t.push(this.menu.first.list[n].name),e.push({name:this.menu.first.list[n].name,value:this.menu.first.list[n].num});l.a.init(this.$refs.chart).setOption({tooltip:{trigger:"item",formatter:"{a} <br/>{b} : {c} ({d}%)"},legend:{type:"scroll",orient:"vertical",right:10,top:20,bottom:20,data:t},series:[{name:"数量",type:"pie",data:e,label:{formatter:"{b}({d}%)"},itemStyle:{emphasis:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]})},exportExcel:function(){var t={parameters:{pid:this.provinceId||null,cid:this.cityId||null,start:this.startTime||null,end:this.endTime||null,type:this.menu.first.id||null}};this.$API.StatisticMaintainExport(t).then(function(t){var e=new Blob([t],{type:"application/vnd.ms-excel"}),i=window.URL.createObjectURL(e),n=document.createElement("a");n.href=i,n.download="Excel.xlsx",n.click(),window.URL.revokeObjectURL(i)})},createMenuIndex:function(t){for(var e=0;e<t.length;e++)t[e].list?(this.menuIndex[t[e].id]={name:t[e].name,child:t[e].list,num:t[e].num},this.menuLevel+=1,this.createMenuIndex(t[e].list)):this.menuIndex[t[e].id]={name:t[e].name,child:null,num:t[e].num};this.menuLevel>1&&(this.menuLevel-=1)},handleMenuFirstClick:function(t){this.menu.first.id=t,this.menu.first.name=this.menuIndex[t].name,this.menu.second.id=0,this.menu.second.name=0,this.menu.second.list=this.menuIndex[t].child},handleMenuSecondClick:function(t){this.menu.second.id=t,this.menu.second.name=this.menuIndex[t].name}},mounted:function(){var t=this;this.$API.LocationGetP().then(function(e){t.locationPOptions=e})}},c=(i(697),i(8)),o=Object(c.a)(a,n,[],!1,null,"5edd9644",null);o.options.__file="src/views/Statistic/Maintain.vue";e.default=o.exports}}]);