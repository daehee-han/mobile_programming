const request = require('request');
const cheerio = require('cheerio');

const url = "http://portal.ndhs.or.kr/studentLifeSupport/carte/list";

request(url, (error, response, body) => {
  if (error) throw error;

  let $ = cheerio.load(body);

  try {
    let krDay = '';
    let time = '';
    let menu = '';

    $('table').find('tr').each(function (index, elem) {
      if (index % 6 === 0) {
        krDay = $(this).find('th').text().trim();

        console.log(`${krDay}`);
      } else {
        time = $(this).find('th').text().trim();
        menu = $(this).find('th').next().text().trim();

        console.log(`${time} -> ${menu}`);
      }
    });
  } catch (error) {
    console.error(error);
  }
