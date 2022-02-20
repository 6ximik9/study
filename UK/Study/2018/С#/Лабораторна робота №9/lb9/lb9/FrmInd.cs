using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb9
{
    public partial class FrmInd : Form
    {
        public FrmInd()
        {
            InitializeComponent();
        }

        private void Obrax_Click(object sender, EventArgs e)
        {
            double Xmin = double.Parse(txtBoxXmin.Text);
            double Xmax = double.Parse(txtBoxXmax.Text);
            double Steep = double.Parse(txtBoxSh.Text);

            //Кількість точок графіка
            int count = (int)Math.Ceiling((Xmax - Xmin) / Steep)
            + 1;
            
            //Масив значень Х - спільний для обох графіків
            double[] x = new double[count];

            //Два масива У - по одноиу для кожного графіка
            double[] y1 = new double[count];
            double[] y2 = new double[count];
            
            //Розраховуємо точки для графіків функцій
            for (int i = 0; i < count; i++)
            {
                //Обраховуэмо значення X
                x[i] = Xmin + Steep * i;
                //Вираховуємо значення функцій в точці X
                y1[i] = x * Math.Sin(Math.Sqrt(x + 0.0084)); 
             //   y2[i] = x * Math.Sin(Math.Sqrt(x + 0.0084)); ;
            }


            //Настройка осей графіка
            chart1.ChartAreas[0].AxisX.Minimum = Xmin;
            chart1.ChartAreas[0].AxisX.Maximum = Xmax;

            //Інтервал сітки
            chart1.ChartAreas[0].AxisX.MajorGrid.Interval = Steep;

            //Додаємо обрахування в графіки
            chart1.Series[1].Points.DataBindXY(x, y1);
            chart1.Series[0].Points.DataBindXY(x, y2);
        }
    }
}
