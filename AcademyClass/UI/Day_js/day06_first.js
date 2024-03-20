// const num1 = parseInt(prompt("첫번째 양의 정수 : "));
// const num2 = parseInt(prompt("두번째 양의 정수 : "));
// let str;

// if(num1 % 2 === 0 && num2 % 2 === 0){
//   str = "두 수 모두 짝수입니다.";
// }else{
//   str = "짝수가 아닌 수가 있습니다.";
// }
// alert(str);


// 3의 배수 체크하기
// let userNumber = prompt("숫자를 입력하세요.");

// if(userNumber !== null)
// {
//   userNumber = parseInt(userNumber);
//   if(userNumber % 3 === 0)
//     alert("3의 배수입니다.");
//   else
//     alert("3의 배수가 아닙니다.");
// }
// else{
//   alert("입력이 취소됐습니다.");
// }

// 짝수, 홀수 구분하는 프로그램
// let userNumber = prompt("숫자를 입력하세요");
// if(userNumber !== null){
//   userNumber = parseInt(userNumber);
//   (userNumber % 2 === 0) ? alert(`${userNumber} : 짝수`) : alert(`${userNumber} : 홀수`);
// }

let subject = prompt("신청 과목 선택. 숫자만 입력(1-HTML, 2-CSS, 3-JavaScript)");

if(subject !== null){
  switch(subject){
    case "1" : alert("HTML을 신청했습니다.");
    break;
    case "2" : document.write("CSS을 신청했습니다.");
    break;
    case "3" : document.write("Javascript을 신청했습니다.");
    break;
    default : document.write("잘못 입력했습니다. 다시 입력해 주세요.")
  }
}