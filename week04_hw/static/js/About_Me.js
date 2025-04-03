const content = "안녕하세요! \n저는 13기 아기사자 최서아입니다 ! \n열심히 하겠습니다 !! "

const text = document.getElementById("dynamic");
let index = 0;
let txt = "";

function typing(){
    if(index < content.length){
    txt += content[index];
    text.innerText = txt;
    index++
    }
}
setInterval(typing,320);