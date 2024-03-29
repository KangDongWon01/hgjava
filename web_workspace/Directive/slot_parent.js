//slot_parent.js
import childComponent from './slot_child.js';

let template = `
    <div>
        <childComponent>
            <template v-slot:title>
                <h1> popup title
`;