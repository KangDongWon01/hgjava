//list.js
let template = `
    <div>
        <!-- 프로퍼티 없이 v-for -->
        <ul>
            <li v-for = "num in 5" v-bind:key="num">
                {{num}}
            </li>
        </ul>
        <!-- 객체가 아닌 단일값 배열을 활용 -->
        <ul>
            <li v-for = "data in myArray">{{data}}</li>
        </ul>
        <ul>
            <li v-for = "(data,index) in myArray" :key="index">{{index}} : {{data}}</li>
        </ul>
        <!-- 객체 배열을 활용 -->
        <p>1)</p>
        <div>
            <ul v-for="user in users" :key="user.id">
                <li>{{user.id}}</li>
                <li>{{user.name}}</li>
                <li>{{user.age}}</li>
            </ul>
        </div>
        <hr>
        <p>2)</p>
        <div>
        <ul v-for="user in users" :key="user.id">
            <li v-for="(value, name, idx) in user" : key="value">
            {{name}} : {{value}} : {{idx}}</li>
        </ul>
    </div>
    </div>
`;

export default{
    template,
    data(){
        return {
            myArray : ['김밥','샌드위치','햄버거','라면'],
            users : [
                {
                    id : 1,
                    name : 'Kang',
                    age : 93
                },
                {
                    id : 2,
                    name : 'choi',
                    age : 98
                },
                {
                    id : 3,
                    name : 'jeon',
                    age : 96
                },
            ]
        }
    }
}