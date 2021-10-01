/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: Oct 1, 2021
 */

SELECT name, MAX(emotion) AS modus FROM data GROUP BY name ORDER BY emotion DESC

SELECT name, MAX(emotion) AS modus, AVG(score) AS Average FROM data GROUP BY name, created ORDER BY emotion DESC
