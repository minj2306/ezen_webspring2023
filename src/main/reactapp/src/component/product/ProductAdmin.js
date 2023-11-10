/*
    mui 탭 매뉴
*/
import * as React from 'react';
import Box from '@mui/material/Box';
import Tab from '@mui/material/Tab';
import TabContext from '@mui/lab/TabContext'; // npm i @mui/lab 설치 필수
import TabList from '@mui/lab/TabList';
import TabPanel from '@mui/lab/TabPanel';
import CategoryWrite from './CategoryWrite';
import ProductInfo from './ProductInfo';
import ProductList from './ProductList';
import ProductWrite from './ProductWrite';

import axios from 'axios';
import { useEffect , useState } from 'react'

export default function ProductAdmin( props ){

    const [value, setValue] = React.useState('1');

    const handleChange = (event: React.SyntheticEvent, newValue: string) => {
        setValue(newValue);
      };
    // 출력할 카테고리 목록을 저장하는 상태변수
    const [ categoryList , setCategoryList ] = useState([]);
        // 2. 카테고리 출력 AXIOS // 컴포넌트가 열렸을때 / 등록 되었을때[ 재랜더링 ]
        const printCategory = (e)=>{
            axios.get('/product/category')
            .then( r => {
            console.log( r.data )
            setCategoryList(r.data);
            } )
        }

    return(<>
        <h3>제품관리 페이지</h3>
        <Box sx={{ width: '100%', typography: 'body1' }}>
              <TabContext value={value}>
                <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
                  <TabList
                  onChange={handleChange}
                  aria-label="lab API tabs example"
                  indicatorColor="secondary"
                  centered
                  >
                    <Tab label="카테고리 등록" value="1" />
                    <Tab label="제품등록" value="2" />
                    <Tab label="제품목록" value="3" />
                    <Tab label="제품상태" value="4" />
                  </TabList>
                </Box>
                {/*탭 선택시 출력되는 내용물*/}
                <TabPanel value="1">
                    <CategoryWrite categoryList={categoryList} printCategory={printCategory}/>
                </TabPanel>
                <TabPanel value="2">
                    <ProductWrite categoryList={categoryList} printCategory={printCategory} />
                </TabPanel>
                <TabPanel value="3"><ProductList/></TabPanel>
                <TabPanel value="4"><ProductInfo/></TabPanel>
              </TabContext>
            </Box>

    </>)
}