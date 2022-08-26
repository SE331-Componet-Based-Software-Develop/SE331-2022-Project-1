const menu = {
    list() {
        return [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"Vaccine Types List","menuJump":"列表","tableName":"yimiaoleixing"}],"menu":"Vaccine Types Management"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"Vaccine Name List","menuJump":"列表","tableName":"yimiaomingcheng"}],"menu":"Vaccine Name Management"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"Latest Announcement List","menuJump":"列表","tableName":"zuixingonggao"}],"menu":"Latest Announcement Management"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"Personnel List","menuJump":"列表","tableName":"yuangong"}],"menu":"Personnel Management"}],"frontMenu":[],"roleName":"Administrators","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"Vaccine Name List","menuJump":"列表","tableName":"yimiaomingcheng"}],"menu":"Vaccine Name Management"},{"child":[{"buttons":["查看"],"menu":"Latest Announcement List","menuJump":"列表","tableName":"zuixingonggao"}],"menu":"Latest Announcement Management"}],"frontMenu":[],"roleName":"Personnel","tableName":"yuangong"}]
    }
}
export default menu;




