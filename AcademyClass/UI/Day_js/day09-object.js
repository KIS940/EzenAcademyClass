let book1 ={
  title : "웹 표준의 정석",
  pages : 648
}

book1.pages = 50
book1.author = "고경희"
document.write(`${book1.title},${book1.pages},${book1.author}`);

let student = {
  name : "Doremi",
  score : {
    history : 85,
    science : 94,
    average : function (){ 
      return (this.history + this.science) / 2
    }
  }
}
console.log(student.score.history)
console.log(student.score.average())