let book3 = {
  title : "점프 투 파이썬",
  pages : 360,
  buy : function(){
    console.log("이 책을 구입했습니다.");
  }
}

let book4 ={
  title : "Javascript",
  pages : 500,
  author : "고경희",
  done : false,
  finish : function(){
    this.done === false ? console.log("읽는 중") : console.log("완독");
  }
}
book4.finish()