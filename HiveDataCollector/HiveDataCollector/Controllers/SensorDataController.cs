using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace HiveDataCollector.Controllers
{
    [Route("api/urbanhive")]
    [ApiController]
    public class SensorDataController : ControllerBase
    {
        private IHiveDatastore datastore;
        public SensorDataController(IHiveDatastore data)
        {
            datastore = data;
        }

        // POST api/values
        [HttpPost]
        public IActionResult Post([FromBody] VibrationDataStructure package)
        {
            var timeReceived = DateTime.Now;
            package.collecting_time = timeReceived;
            if (package.gyro_data?.Length != 1500)
            {
                return BadRequest("Invalid data");
            }
            datastore.Save(package);
            return Ok("thank you baby");
        }

        [HttpGet]
        public JsonResult Get(int number=1)
        {
            return new JsonResult(datastore.Load(number));
        }

        [HttpGet("About")]
        public ContentResult About()
        {
            return Content("we are hive team, we are awesome");
        }
    }
}
