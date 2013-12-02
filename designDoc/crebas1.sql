/*==============================================================*/
/* Database name:  BILLPRO                                      */
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2013-11-9 20:49:47                           */
/*==============================================================*/


use master
go
drop database BILLPRO
go

use master
go
/*==============================================================*/
/* Database: BILLPRO                                            */
/*==============================================================*/
create database BILLPRO
go

use BILLPRO
go

/*==============================================================*/
/* Table: EC_Account                                            */
/*==============================================================*/
create table EC_Account (
   id                   varchar(48)          not null,
   tax_id               varchar(64)          null,
   account_type         char(1)              null,
   nickname             varchar(30)          not null,
   account_name         varchar(30)          not null,
   password             varchar(200)         not null,
   email                varchar(100)         null,
   register_time        datetime             not null,
   last_login_time      datetime             null,
   view_number          int                  null,
   user_name            varchar(50)          not null,
   enabled              char(1)              not null,
   del_flag             tinyint              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_EC_ACCOUNT primary key nonclustered (id),
   constraint AK_ACC_ACCOUNT_NAME_EC_ACCOU unique (account_name)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '用户账户',
   'user', @CurrentUser, 'table', 'EC_Account'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征机构ID',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'tax_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '账户类型',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'account_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '昵称',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'nickname'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '账户名',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'account_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '密码',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'password'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '邮箱',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'email'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '注册时间',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'register_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后登录时间',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'last_login_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '访问次数',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'view_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '用户姓名',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'user_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '启用标识',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'enabled'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标识',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新人',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'EC_Account', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: EC_Account_Role                                       */
/*==============================================================*/
create table EC_Account_Role (
   acc_id               varchar(48)          not null,
   rol_id               varchar(48)          not null,
   constraint PK_EC_ACCOUNT_ROLE primary key nonclustered (acc_id, rol_id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '账户角色',
   'user', @CurrentUser, 'table', 'EC_Account_Role'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '账户_ID',
   'user', @CurrentUser, 'table', 'EC_Account_Role', 'column', 'acc_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '角色_ID',
   'user', @CurrentUser, 'table', 'EC_Account_Role', 'column', 'rol_id'
go

/*==============================================================*/
/* Table: EC_Appendix                                           */
/*==============================================================*/
create table EC_Appendix (
   id                   varchar(48)          not null,
   owner                varchar(150)         not null,
   owner_key            varchar(100)         not null,
   appendix_type        varchar(10)          not null,
   url                  varchar(255)         not null,
   author               varchar(50)          null,
   upload_time          datetime             null,
   del_flag             tinyint              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_EC_APPENDIX primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '拥有附件者',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'owner'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '拥有附件对象_ID',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'owner_key'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '附件类型',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'appendix_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '附件地址',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'url'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '上传者',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'author'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '上传日期',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'upload_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标识',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新人',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'EC_Appendix', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: EC_Authority                                          */
/*==============================================================*/
create table EC_Authority (
   id                   varchar(48)          not null,
   module_name          varchar(30)          not null,
   module_description   varchar(100)         null,
   module_url           varchar(255)         null,
   function_name        varchar(30)          not null,
   function_description varchar(100)         null,
   function_url         varchar(255)         null,
   del_flag             tinyint              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_EC_AUTHORITY primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能权限',
   'user', @CurrentUser, 'table', 'EC_Authority'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能权限_ID',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能模块名称',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'module_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能模块描述',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'module_description'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '模块地址',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'module_url'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能点名称',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'function_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能点描述',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'function_description'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能点地址',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'function_url'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标识',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新人',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'EC_Authority', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: EC_Code                                               */
/*==============================================================*/
create table EC_Code (
   id                   varchar(48)          not null,
   type_name            varchar(50)          not null,
   type_code            int                  not null,
   name                 varchar(50)          not null,
   code                 varchar(4)           not null,
   has_children         char(1)              not null default '0',
   child_type           int                  null,
   remark               varchar(200)         null,
   use_flag             char(1)              not null,
   del_flag             tinyint              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_EC_CODE primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '字典编码',
   'user', @CurrentUser, 'table', 'EC_Code'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'ID',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型名称',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'type_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型编码',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'type_code'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '类型编码',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '名称',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'code'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '编码',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'has_children'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '有无子类',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'child_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '子类类型',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'remark'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '备注',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'use_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标识',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新人',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'EC_Code', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: EC_District                                           */
/*==============================================================*/
create table EC_District (
   id                   varchar(48)          not null,
   district_code        varchar(6)           not null,
   district_name        varchar(150)         not null,
   district_ab          varchar(40)          null,
   district_level       varchar(1)           not null,
   province             varchar(2)           not null,
   province_name        varchar(50)          not null,
   province_ab          varchar(12)          null,
   city                 varchar(2)           not null,
   city_name            varchar(50)          not null,
   city_ab              varchar(14)          null,
   county               varchar(2)           not null,
   county_name          varchar(50)          not null,
   county_ab            varchar(25)          null,
   last_modify_by       varchar(50)          null,
   last_modify_time     datetime             null,
   create_by            varchar(50)          null,
   create_time          datetime             not null,
   del_flag             tinyint              not null,
   constraint PK_pub_province primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '行政区划',
   'user', @CurrentUser, 'table', 'EC_District'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '1：省；2：市；3：区（县）',
   'user', @CurrentUser, 'table', 'EC_District', 'column', 'district_level'
go

/*==============================================================*/
/* Table: EC_Role                                               */
/*==============================================================*/
create table EC_Role (
   id                   varchar(48)          not null,
   role_name            varchar(50)          not null,
   role_description     varchar(150)         null,
   del_flag             tinyint              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_EC_ROLE primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '角色',
   'user', @CurrentUser, 'table', 'EC_Role'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '角色名称',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'role_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '描述',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'role_description'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标识',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新人',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'EC_Role', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: EC_Role_Authority                                     */
/*==============================================================*/
create table EC_Role_Authority (
   aut_id               varchar(48)          not null,
   rol_id               varchar(48)          not null,
   constraint PK_EC_ROLE_AUTHORITY primary key nonclustered (aut_id, rol_id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '角色权限',
   'user', @CurrentUser, 'table', 'EC_Role_Authority'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '功能_ID',
   'user', @CurrentUser, 'table', 'EC_Role_Authority', 'column', 'aut_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '角色_ID',
   'user', @CurrentUser, 'table', 'EC_Role_Authority', 'column', 'rol_id'
go

/*==============================================================*/
/* Table: collectionStandard                                    */
/*==============================================================*/
create table collectionStandard (
   id                   varchar(64)          not null,
   tax_categories_id    varchar(64)          not null,
   Per_unit_tax_amount  decimal(13,1)        not null,
   tax_rate             decimal(13,5)        not null,
   "behalf_ collected_num" varchar(20)          not null,
   start_date           datetime             not null,
   end_date             datetime             not null,
   start_range          decimal(13,2)        not null,
   end_range            decimal(13,2)        not null,
   "tax bureau_number"  varchar(20)          not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   del_flag             tinyint              not null,
   last_update_by       varchar(50)          not null,
   last_update_time     datetime             not null,
   constraint PK_COLLECTIONSTANDARD primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收标准(collectionStandard)',
   'user', @CurrentUser, 'table', 'collectionStandard'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收标准ID',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税种ID',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'tax_categories_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '单位计税金额',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'Per_unit_tax_amount'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税率',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'tax_rate'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征单位编码',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'behalf_ collected_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收开始时间',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'start_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收结束时间',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'end_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收范围起始',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'start_range'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收范围终止',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'end_range'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收机构编码',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'tax bureau_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'collectionStandard', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: fillInRecord                                          */
/*==============================================================*/
create table fillInRecord (
   id                   varchar(64)          not null,
   bill_id              varchar(64)          null,
   payer_id             varchar(64)          null,
   gs_bill_id           varchar(64)          null,
   bill_type            varchar(50)          not null,
   fill_in_person_num   varchar(50)          not null,
   fill_in_date         datetime             not null,
   fill_in_status       char(1)              collate Chinese_PRC_CI_AS not null,
   fill_in_status_name  varchar(50)          collate Chinese_PRC_CI_AS not null,
   constraint PK_FILLINRECORD primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '开票记录(fillInRecord)',
   'user', @CurrentUser, 'table', 'fillInRecord'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '开票ID',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地税_票证ID',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'bill_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税ID',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'payer_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '国税_票证ID',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'gs_bill_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '开票人',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'fill_in_person_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开日期',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'fill_in_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开状态',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'fill_in_status'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开状态名称',
   'user', @CurrentUser, 'table', 'fillInRecord', 'column', 'fill_in_status_name'
go

/*==============================================================*/
/* Table: nationalTaxCertificate                                */
/*==============================================================*/
create table nationalTaxCertificate (
   id                   varchar(64)          not null,
   provide_id           varchar(64)          not null,
   bill_type            char(2)              not null,
   bill_num             bigint               not null,
   batch_num            varchar(10)          collate Chinese_PRC_CI_AS not null,
   fill_in_person_num   varchar(50)          collate Chinese_PRC_CI_AS not null,
   fill_in_person_name  varchar(50)          collate Chinese_PRC_CI_AS not null,
   registration_type    varchar(50)          null,
   registration_name    varchar(50)          null,
   fill_in_date         datetime             null,
   "tax bureau_number"  varchar(50)          null,
   taxpayer_number      varchar(50)          null,
   taxpayer_name        varchar(50)          null,
   Tax_period_start     datetime             null,
   Tax_period_end       datetime             null,
   vat                  decimal(13,2)        null,
   educational_surcharge decimal(13,2)        null,
   place_educational_surcharge decimal(13,2)        null,
   price_regulation_fund decimal(13,2)        null,
   create_by            decimal(13,2)        null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_kpjl primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '国税完税证(nationalTaxCertificate)',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证ID',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放ID',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'provide_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发票号码',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'bill_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '批次号',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'batch_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开人编码',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'fill_in_person_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开人名称',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'fill_in_person_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型编码',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'registration_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型名称',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'registration_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开日期',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'fill_in_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收机关',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'tax bureau_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人识别号',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'taxpayer_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人名称',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'taxpayer_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税款所属时期起',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'Tax_period_start'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税款所属时期止',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'Tax_period_end'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '增值税',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'vat'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '教育费附加',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'educational_surcharge'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地方教育费附加',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'place_educational_surcharge'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '价格调节基金',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'price_regulation_fund'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'nationalTaxCertificate', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: payerRecord                                           */
/*==============================================================*/
create table payerRecord (
   id                   varchar(64)          not null,
   payer_id             varchar(64)          not null,
   Tax_period_start     datetime             not null,
   Tax_period_end       datetime             not null,
   pay_taxes_date       datetime             not null,
   constraint PK_PAYERRECORD primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税记录(payerRecord)',
   'user', @CurrentUser, 'table', 'payerRecord'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税ID',
   'user', @CurrentUser, 'table', 'payerRecord', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人_id',
   'user', @CurrentUser, 'table', 'payerRecord', 'column', 'payer_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '所属时期起',
   'user', @CurrentUser, 'table', 'payerRecord', 'column', 'Tax_period_start'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '所属时期止',
   'user', @CurrentUser, 'table', 'payerRecord', 'column', 'Tax_period_end'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税日期',
   'user', @CurrentUser, 'table', 'payerRecord', 'column', 'pay_taxes_date'
go

/*==============================================================*/
/* Table: payerRecordDetail                                     */
/*==============================================================*/
create table payerRecordDetail (
   id                   varchar(64)          not null,
   tax_id               varchar(64)          not null,
   pay_tax_id           varchar(64)          not null,
   tax_amount           decimal(13,2)        not null,
   tax_payable          decimal(13,2)        not null,
   constraint PK_PAYERRECORDDETAIL primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税记录明细(payerRecordDetail)',
   'user', @CurrentUser, 'table', 'payerRecordDetail'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税记录ID',
   'user', @CurrentUser, 'table', 'payerRecordDetail', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收标准ID',
   'user', @CurrentUser, 'table', 'payerRecordDetail', 'column', 'tax_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税ID',
   'user', @CurrentUser, 'table', 'payerRecordDetail', 'column', 'pay_tax_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '计税金额',
   'user', @CurrentUser, 'table', 'payerRecordDetail', 'column', 'tax_amount'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '应纳税额',
   'user', @CurrentUser, 'table', 'payerRecordDetail', 'column', 'tax_payable'
go

/*==============================================================*/
/* Table: placeTaxCertificate                                   */
/*==============================================================*/
create table placeTaxCertificate (
   id                   varchar(64)          not null,
   provide_id           varchar(64)          not null,
   bill_type            char(2)              not null,
   bill_num             bigint               not null,
   batch_num            varchar(10)          collate Chinese_PRC_CI_AS not null,
   fill_in_person_num   varchar(50)          collate Chinese_PRC_CI_AS not null,
   fill_in_person_name  varchar(50)          collate Chinese_PRC_CI_AS not null,
   registration_type    varchar(50)          null,
   registration_name    varchar(50)          null,
   fill_in_date         datetime             null,
   "tax bureau_number"  varchar(50)          null,
   taxpayer_number      varchar(50)          null,
   taxpayer_name        varchar(50)          null,
   tax_period_start     datetime             null,
   tax_period_end       datetime             null,
   other_personal_income decimal(13,2)        null,
   "other_city building" decimal(13,2)        null,
   oter_stamp_duty      decimal(13,2)        null,
   educational_surcharge decimal(13,2)        null,
   place_educational_surcharge decimal(13,2)        null,
   price_regulation_fund decimal(13,2)        null,
   create_by            varchar(50)          null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_PLACETAXCERTIFICATE primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地税完税证(placeTaxCertificate)',
   'user', @CurrentUser, 'table', 'placeTaxCertificate'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证ID',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放ID',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'provide_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发票号码',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'bill_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '批次号',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'batch_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开人编码',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'fill_in_person_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开人名称',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'fill_in_person_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型编码',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'registration_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型名称',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'registration_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '填开日期',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'fill_in_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '征收机关',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'tax bureau_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人识别号',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'taxpayer_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人名称',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'taxpayer_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税款所属时期起',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'tax_period_start'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税款所属时期止',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'tax_period_end'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '其他个人所得税',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'other_personal_income'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '其他企业城市维建税',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'other_city building'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '其他印花税',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'oter_stamp_duty'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '教育费附加',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'educational_surcharge'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地方教育费附加',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'place_educational_surcharge'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '价格调节基金',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'price_regulation_fund'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'placeTaxCertificate', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: printFormat                                           */
/*==============================================================*/
create table printFormat (
   id                   varchar(64)          not null,
   printFormat_code     varchar(50)          collate Chinese_PRC_CI_AS not null,
   printFormat_name     varchar(50)          collate Chinese_PRC_CI_AS not null,
   printFormat_text     varchar(100)         collate Chinese_PRC_CI_AS not null,
   national_left        int                  not null,
   national_top         int                  not null,
   place_left           int                  not null,
   place_top            int                  not null,
   create_by            varchar(50)          null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_dygs primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '打印格式（printFormat）',
   'user', @CurrentUser, 'table', 'printFormat'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '打印格式ID',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '打印格式编码',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'printFormat_code'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '打印格式名称',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'printFormat_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '打印格式内容',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'printFormat_text'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '国税左',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'national_left'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '国税上',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'national_top'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地税左',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'place_left'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '地税上',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'place_top'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'printFormat', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: provideRecord                                         */
/*==============================================================*/
create table provideRecord (
   id                   varchar(64)          not null,
   storage_id           varchar(64)          not null,
   bill_type            char(2)              null,
   batch_num            varchar(10)          collate Chinese_PRC_CI_AS not null,
   start_num            varchar(10)          not null,
   end_num              varchar(10)          not null,
   receive_num          varchar(50)          collate Chinese_PRC_CI_AS null,
   receive_name         varchar(50)          collate Chinese_PRC_CI_AS null,
   provide_num          varchar(50)          collate Chinese_PRC_CI_AS null,
   provide_name         varchar(50)          collate Chinese_PRC_CI_AS null,
   provide_date         datetime             null,
   create_by            varchar(50)          null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_ffjl primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放记录(provideRecord)',
   'user', @CurrentUser, 'table', 'provideRecord'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放ID',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '库存ID',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'storage_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '批次号',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'batch_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '起始号码',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'start_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '终止号码',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'end_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用人编码',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'receive_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用人名称',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'receive_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放人编码',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'provide_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放人名称',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'provide_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '发放日期',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'provide_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'provideRecord', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: receiveRecord                                         */
/*==============================================================*/
create table receiveRecord (
   id                   varchar(64)          not null,
   batch_num            varchar(10)          collate Chinese_PRC_CI_AS not null,
   start_num            varchar(10)          not null,
   end_num              varchar(10)          not null,
   login_name           varchar(20)          collate Chinese_PRC_CI_AS null,
   bill_type            char(2)              null,
   receive_date         datetime             null,
   create_by            varchar(50)          null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   bill_status          char(1)              null,
   constraint PK_lyjl primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用记录（receiveRecord）',
   'user', @CurrentUser, 'table', 'receiveRecord'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用ID',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '批次号',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'batch_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '起始号码',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'start_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '终止号码',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'end_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用人',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'login_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领证日期',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'receive_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'last_update_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '记录状态',
   'user', @CurrentUser, 'table', 'receiveRecord', 'column', 'bill_status'
go

/*==============================================================*/
/* Table: registrationType                                      */
/*==============================================================*/
create table registrationType (
   id                   varchar(64)          collate Chinese_PRC_CI_AS not null,
   registration_type    varchar(20)          collate Chinese_PRC_CI_AS not null,
   registration_name    varchar(100)         collate Chinese_PRC_CI_AS not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   del_flag             tinyint              not null,
   last_update_by       varchar(50)          not null,
   last_update_time     datetime             not null,
   constraint PK_REGISTRATIONTYPE primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型（registrationType）',
   'user', @CurrentUser, 'table', 'registrationType'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型id',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型编码',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'registration_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型名称',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'registration_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'registrationType', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: storage                                               */
/*==============================================================*/
create table storage (
   id                   varchar(64)          not null,
   receive_id           varchar(64)          not null,
   bill_type            char(2)              null,
   batch_num            varchar(10)          collate Chinese_PRC_CI_AS not null,
   start_num            varchar(10)          not null,
   end_num              varchar(10)          not null,
   create_by            varchar(50)          null,
   create_time          datetime             null,
   del_flag             tinyint              null,
   last_update_by       varchar(50)          null,
   last_update_time     datetime             null,
   constraint PK_kcqk primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '库存情况（storage）',
   'user', @CurrentUser, 'table', 'storage'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '库存ID',
   'user', @CurrentUser, 'table', 'storage', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '领用ID',
   'user', @CurrentUser, 'table', 'storage', 'column', 'receive_id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '票证种类',
   'user', @CurrentUser, 'table', 'storage', 'column', 'bill_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '批次号',
   'user', @CurrentUser, 'table', 'storage', 'column', 'batch_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '起始号码',
   'user', @CurrentUser, 'table', 'storage', 'column', 'start_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '终止号码',
   'user', @CurrentUser, 'table', 'storage', 'column', 'end_num'
go

/*==============================================================*/
/* Table: taxBureauPro                                          */
/*==============================================================*/
create table taxBureauPro (
   id                   varchar(64)          not null,
   taxBureauPro_code    char(11)             collate Chinese_PRC_CI_AS not null,
   taxBureauPro_name    varchar(60)          collate Chinese_PRC_CI_AS not null,
   registrate_symbol    char(1)              collate Chinese_PRC_CI_AS not null,
   constraint PK_TAXBUREAUPRO primary key (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征机构（taxBureauPro）',
   'user', @CurrentUser, 'table', 'taxBureauPro'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征机构ID',
   'user', @CurrentUser, 'table', 'taxBureauPro', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征机构代码',
   'user', @CurrentUser, 'table', 'taxBureauPro', 'column', 'taxBureauPro_code'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '代征机构名称',
   'user', @CurrentUser, 'table', 'taxBureauPro', 'column', 'taxBureauPro_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '注册标志',
   'user', @CurrentUser, 'table', 'taxBureauPro', 'column', 'registrate_symbol'
go

/*==============================================================*/
/* Table: taxItems                                              */
/*==============================================================*/
create table taxItems (
   id                   varchar(64)          not null,
   tax_categories_num   char(2)              not null,
   tax_categories_name  varchar(50)          not null,
   tax_items_num        char(4)              not null,
   tax_items_name       varchar(50)          not null,
   Enabled_flag         char(1)              not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   del_flag             tinyint              not null,
   last_update_by       varchar(50)          not null,
   last_update_time     datetime             not null,
   constraint PK_TAXITEMS primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税种(taxItems)',
   'user', @CurrentUser, 'table', 'taxItems'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税种ID',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税种编码',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'tax_categories_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '税种名称',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'tax_categories_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '品目编码',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'tax_items_num'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '品目名称',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'tax_items_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '启用标志',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'Enabled_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'taxItems', 'column', 'last_update_time'
go

/*==============================================================*/
/* Table: taxpayerMange                                         */
/*==============================================================*/
create table taxpayerMange (
   id                   varchar(64)          not null,
   licenseplate         varchar(50)          collate Chinese_PRC_CI_AS not null,
   ID_number            varchar(50)          collate Chinese_PRC_CI_AS null,
   name                 varchar(50)          collate Chinese_PRC_CI_AS null,
   registration_type    varchar(50)          collate Chinese_PRC_CI_AS not null,
   registration_name    varchar(50)          collate Chinese_PRC_CI_AS not null,
   address              varchar(50)          collate Chinese_PRC_CI_AS null,
   taxpayer_name        varchar(50)          collate Chinese_PRC_CI_AS not null,
   tax_registration_date datetime             null,
   verification_date    datetime             not null,
   verification_tonnage decimal(13,1)        not null,
   taxpayer_number      varchar(50)          collate Chinese_PRC_CI_AS not null,
   Transport_type       varchar(50)          collate Chinese_PRC_CI_AS not null,
   Transport_name       varchar(50)          collate Chinese_PRC_CI_AS not null,
   contact_number       varchar(50)          collate Chinese_PRC_CI_AS not null,
   create_by            varchar(50)          not null,
   create_time          datetime             not null,
   del_flag             tinyint              not null,
   last_update_by       varchar(50)          not null,
   last_update_time     datetime             not null,
   transportpermits_number varchar(50)          not null,
   constraint PK_nsrgl primary key nonclustered (id)
)
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人管理（taxpayerMange）',
   'user', @CurrentUser, 'table', 'taxpayerMange'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人id',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'id'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '车牌号码',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'licenseplate'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '身份证号',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'ID_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '姓名',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'registration_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '登记注册类型名称',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'registration_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '生产经营地址',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'address'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人名称',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'taxpayer_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '办理税务登日期',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'tax_registration_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '核定日期',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'verification_date'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '核定吨位/座位数',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'verification_tonnage'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '纳税人识别号',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'taxpayer_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '运输类型编码',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'Transport_type'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '运输类型名称',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'Transport_name'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '联系电话',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'contact_number'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建者',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'create_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '创建时间',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'create_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '删除标志',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'del_flag'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新者',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'last_update_by'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '最后更新时间',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'last_update_time'
go

declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   '运输许可证编码',
   'user', @CurrentUser, 'table', 'taxpayerMange', 'column', 'transportpermits_number'
go

/*==============================================================*/
/* Index: Index_2                                               */
/*==============================================================*/
create unique index Index_2 on taxpayerMange (
licenseplate ASC
)
go

/*==============================================================*/
/* Index: _WA_Sys_sfzh_70DDC3D8                                 */
/*==============================================================*/
create index _WA_Sys_sfzh_70DDC3D8 on taxpayerMange (
ID_number ASC
)
go

alter table EC_Account
   add constraint FK_EC_ACCOU_FK_TAXBUR_TAXBUREA foreign key (tax_id)
      references taxBureauPro (id)
go

alter table EC_Account_Role
   add constraint FK_AR_ACC foreign key (acc_id)
      references EC_Account (id)
go

alter table EC_Account_Role
   add constraint FK_AR_ROL foreign key (rol_id)
      references EC_Role (id)
go

alter table EC_Role_Authority
   add constraint FK_AUT_ROL foreign key (rol_id)
      references EC_Role (id)
go

alter table EC_Role_Authority
   add constraint FK_RA_AUT foreign key (aut_id)
      references EC_Authority (id)
go

alter table collectionStandard
   add constraint FK_COLLECTI_FK_TAXITE_TAXITEMS foreign key (tax_categories_id)
      references taxItems (id)
go

alter table fillInRecord
   add constraint FK_FILLINRE_FK_NATION_NATIONAL foreign key (gs_bill_id)
      references nationalTaxCertificate (id)
go

alter table fillInRecord
   add constraint FK_FILLINRE_FK_PAYERR_PAYERREC foreign key (payer_id)
      references payerRecord (id)
go

alter table fillInRecord
   add constraint FK_FILLINRE_FK_PLACET_PLACETAX foreign key (bill_id)
      references placeTaxCertificate (id)
go

alter table nationalTaxCertificate
   add constraint FK_NATIONAL_FK_PROVID_PROVIDER foreign key (provide_id)
      references provideRecord (id)
go

alter table payerRecord
   add constraint FK_PAYERREC_FK_TAXPAY_TAXPAYER foreign key (payer_id)
      references taxpayerMange (id)
go

alter table payerRecordDetail
   add constraint FK_PAYERREC_FK_COLLEC_COLLECTI foreign key (tax_id)
      references collectionStandard (id)
go

alter table payerRecordDetail
   add constraint FK_PAYERREC_FK_PAYERR_PAYERREC foreign key (pay_tax_id)
      references payerRecord (id)
go

alter table placeTaxCertificate
   add constraint FK_PLACETAX_FK_PROVID_PROVIDER foreign key (provide_id)
      references provideRecord (id)
go

alter table provideRecord
   add constraint FK_PROVIDER_FK_STORAG_STORAGE foreign key (storage_id)
      references storage (id)
go

alter table storage
   add constraint FK_STORAGE_FK_RECEIV_RECEIVER foreign key (receive_id)
      references receiveRecord (id)
go

