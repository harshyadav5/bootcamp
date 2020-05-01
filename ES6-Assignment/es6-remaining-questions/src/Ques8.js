const pi = 3.14;

const areaOfCircle = (r)=>pi*Math.pow(r, 2);

const areaOfRectangle = (a, b)=>a*b;

const areaOfCylinder = (r, h)=> Math.PI*r*h*(r+h);

export {areaOfCircle, areaOfRectangle, areaOfCylinder};
