//conponent.js

let component = {
                    // 컴포넌트는 <객체>이며, <필드, 속성>을 뷰에서는 <옵션>이라고 부름
    name : '',      // 필수값은 아님. 컴포넌트를 구별해야 할 때 씀.
    template : ``,   //*줄바꿈을 써야 하기 때문에 백틱으로 감싸게 됨. 자바스크립트의 템플릿 문법을 사용한다. View임.
    data(){},       //*컴포넌트가 가지는 데이터를 명확하게 가리키는 말은 프로퍼티property. data임. CRUD 가능.
    computed : {},  //*Data이긴 한데, Read-only 특징이 있다. (data를 기반으로 자동연산) 환율 비교하면 data와 computed를 구별하기가 편함.
    methods : {},   //*컴포넌트 내부에 동작하는 기능들을 모아둠. 이벤트핸들러, 특정 기능의 함수 등.. 컴포넌트는 이 메소드 외부에 있는 함수를 인지하지 못함. Code임.
    watch : {},      //*data, computed 감시.. 프로세스.. 데이터 변화에 따라 진행되는 과정이 있을경우 와치. 메소드에는 기능을 정의. 데이터의 변화에 따른 연속적인 행위는 와치.  
    components : {} // root컴포넌트의 경우 반드시 필요한 옵션. -> 내부에 정의된것만 인식/사용.. 자식 컴포넌트의 경우도 등록을 해 놓아야 함. 자식 컴포넌트를 추가. 
};

// 컴포넌트 하나에 데이터를 여러 덩어리를 받을 수 있다? -> 여러 덩어리를 하나로 만들어 보내면 된다? -> ajax를 여러번 사용한다? -> 