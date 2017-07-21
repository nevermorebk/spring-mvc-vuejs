/*new Vue({
 el: '#vue-app',
 data: {
 name: 'Tran Dang Quang',
 job: 'IT',
 website: 'https://www.google.com.vn',
 websiteTag: '<a href="https://www.google.com.vn">Google</a><br/>',
 age: 17
 },
 methods: {
 greet: function (time) {
 return "Good " + time + " " + this.name;
 }
 }
 });*/

/*new Vue({
    el: '#vue-app',
    data: {
        age: 17,
        x: 0,
        y: 0
    },
    methods: {
        add: function (year) {
            return this.age += year
        },
        subtract: function (year) {
            return this.age -= year
        },
        updateXY: function (event) {
            this.x = event.offsetX;
            this.y = event.offsetY;
        }
    }
});*/

/*
new Vue({
    el: '#vue-app',
    data: {
        name: '',
        age: ''
    },
    methods: {
        logName: function () {
            // this.name =
        },
        logAge: function () {
            console.log('enter your age:')
        }
    }
});*/

/*
new Vue({
    el: '#vue-app',
    data: {
        available: false,
        nearby: false
    },
    methods: {

    },
    computed: {
        compClasses: function () {
            return {
                available: this.available,
                nearby: this.nearby
            }
        }
    }
});*/

/*
new Vue({
    el: '#vue-app',
    data: {
        error: false,
        success: false
    },
    methods: {

    },
    computed: {

    }
});*/


/*
new Vue({
    el: '#vue-app',
    data: {
        characters: ['Mario', 'Luigi', 'Yoshi', 'Bowser'],
        ninias: [
            {name: 'Faker', age: 25},
            {name: 'Bang', age: 25},
            {name: 'Wolf', age: 25}
        ]
    },
    methods: {

    },
    computed: {

    }
});*/

Vue.component('greeting', {
    template: '<p>Hello, I am a component</p>'
});

new Vue({
    el: '#vue-app-one',
    data: {

    },
    methods: {

    },
    computed: {

    }
});

new Vue({
    el: '#vue-app-two',
    data: {

    },
    methods: {


    },
    computed: {

    }
});


