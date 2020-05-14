import { NativeModules } from 'react-native';

const { MyFancyLibrary } = NativeModules;

export default MyFancyLibrary;

interface TurboDB {
    getData() : String,
}

export const TurboDatabase : TurboDB = {
    getData(): String {
        // @ts-ignore
        return global.TurboDatabase.getData();
    },
}
