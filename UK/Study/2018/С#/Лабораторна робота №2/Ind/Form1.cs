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

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox1.Text = "3.981";
            textBox2.Text = "1.625";
            textBox3.Text = "0.512";
        }

        

        private void button1_Click_1(object sender, EventArgs e)
        {
            textBox4.Text = "Програму розробив Хаща Василь";
            double x = double.Parse(textBox1.Text);
            textBox4.Text += Environment.NewLine + "X =" + x.ToString();

            double y = double.Parse(textBox2.Text);
            textBox4.Text += Environment.NewLine + "Y =" + y.ToString();

            double z = double.Parse(textBox3.Text);
            textBox4.Text += Environment.NewLine + "Z =" + z.ToString();

            double a = Math.Tan(x + y) * Math.Tan(x + y);
            double b = Math.Exp(y - z);
            double c = Math.Sqrt(Math.Cos(x * x) + Math.Sin(z * z));
            double u = a - b * c;

            textBox4.Text += Environment.NewLine + "Результат U = " + u.ToString();
        }
    }
}
