//公告弹窗
layui.use('layer', function () {
    var $ = layui.jquery, layer = layui.layer;
    //触发弹窗事件
    window.popnotice = function popnotice() {
        layer.open({
            type: 1,
            title: '<strong>最新公告：</strong>',//公告标题
            closeBtn: false, //不显示标题栏
            area: 'auto;',//提示窗宽度
            shade: 0.8,//透明度
            id: 'CX-Sport', //设定一个id，防止重复弹出
            btn: ['疑难杂症', '我晓得了'],//按钮
            btnAlign: 'c',
            moveType: 1, //拖拽模式，0或者1
            // padding:弹窗两侧边距 line-height:行距
            content: '<div style="padding: 30px; line-height: 24px; background-color: #393D49; color: #fff; font-weight: 300; font-size: 16px;"><p><font color="yellow">新增支持邮箱账号</font></p><p>建议微信步数不要超过5万步，否则被举报会封微信运动排行榜7天，7天后自动解封</p>被封排行榜不会影响微信的使用，仅仅是微信运动7天都是0步</p>如遇疑难杂症请点击下方按钮查看帮助</p>作者QQ：1600198489</p>By:莫威</p>',
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: 'help.html'//跳转地址
                    , target: '_blank'//跳转方式
                });
            }
        });
    }
    $('#layerDemo .layui-btn').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});