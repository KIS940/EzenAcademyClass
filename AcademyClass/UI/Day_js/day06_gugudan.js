for(var i = 2; i <= 9; i++){
  document.write("<div>");
  document.write("<h3>" + i + "단</h3>");
  for(var j = 1; j <= 9; j++){
    document.write(`${i} X ${j} = ${i * j}<br>`);
  }
  document.write("</div>");
}

function calcSum(){
  let sum = 0;
  for(let i = 1; i<= 10; i++){
    sum += i;
  }
  document.write(`1부터 10까지 더하면 ${sum}입니다.`);
}

calcSum();