/**
 * Created by chgu1_000 on 2016/3/17.
 */

$(function(){

        $("#hide").click(function(){
            if($("#left").css('width') != '0px'){
                $("#left1").animate({width:'30px'},"fast");
                $("#left").animate({width:'toggle'},"fast");
                $("#hide").animate({width:'30px'},"fast");
                $("#hide").val('>>');
            }
            if($("#left").css('width') != '196px'){
                $("#left1").animate({width:200},"fast");
                $("#hide").animate({width:180},"fast");
                $("#hide").val('<<');
                $("#left").animate({width:196},"fast");

            }

        });





})


