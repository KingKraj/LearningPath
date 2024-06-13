//call
const wizard = {
  name: "gandolf",
  health: 100,
  heal: function () {
    return (this.health = 100);
  },
};

const archer = {
  name: "robin",
  health: 30,
};

// console.log("before heal", archer);
// wizard.heal.call(archer);
// console.log("after heal", archer);

// wizard.heal.apply(archer);
// console.log("after apply ", archer);

const character = {
  name: 'Simon',
  getCharacter() {
    return this.name;
  }
};
const giveMeTheCharacterNOW = character.getCharacter.bind(character);
 
//How Would you fix this?
console.log('?', giveMeTheCharacterNOW()); 