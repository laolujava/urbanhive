using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HiveDataCollector
{
    public class VibrationDataStructure
    {
        public DateTime collecting_time;
        public DateTime received_time;
        public double geo_longitude;
        public double geo_latitude;
        public double[] gyro_data;
        public string sensor_id;
        public int sensor_type;
    }
    public interface IHiveDatastore
    {
        void Save(VibrationDataStructure data);
        List<VibrationDataStructure> Load(int number);
    }
    public class HiveDatastore: IHiveDatastore
    {
        private int bufferSize;
        private Queue<VibrationDataStructure> datastore;
        public HiveDatastore(int size=100)
        {
            bufferSize = size;
            datastore = new Queue<VibrationDataStructure>();
        }
        public void Save(VibrationDataStructure data)
        {
            if (datastore.Count > bufferSize)
                datastore.Dequeue();
            datastore.Enqueue(data);
        }
        public List<VibrationDataStructure> Load(int number)
        {
            if (number > bufferSize)
                number = bufferSize;
            return datastore.ToList();
        }
    }
}
