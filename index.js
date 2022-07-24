import { NativeModules } from 'react-native';

const { N3Library } = NativeModules;

export function print(jsonData){
    return N3Library.print(jsonData);
};
  
export function getSerialNumber(){
    return  N3Library.getSerialNumber();
}

export default N3Library;

