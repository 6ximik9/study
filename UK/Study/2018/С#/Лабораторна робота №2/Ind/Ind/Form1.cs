using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ind
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox4.Text = "Програму розробив Ганькулич Влентин";
            double x = Convert.ToDouble(textBox1.Text);
            textBox4.Text += Environment.NewLine + "X =" + x.ToString();
            double y = Convert.ToDouble(textBox2.Text);
            textBox4.Text += Environment.NewLine + "Y =" + y.ToString();

            double z = Convert.ToDouble(textBox3.Text);
            textBox4.Text += Environment.NewLine + "Z =" + z.ToString();
               
            double f = Math.Pow(2, -x);
            double b = Math.Sqrt(x+Math.Pow(Math.Sqrt(Math.Abs(y)),1/4));
            double c = Math.Pow(
                                Math.Sqrt(
                                            Math.Pow(Math.Exp(1), x-(1/Math.Sin(z))))
                                ,1/3);
            double a = f * b * c;

            textBox4.Text += Environment.NewLine + "Результат a = " + a.ToString();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
             textBox1.Text = "3,981E-2";
            textBox2.Text = "-1,625E+3";
            textBox3.Text = "0,512";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Frm2 test = new Frm2();
            test.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
